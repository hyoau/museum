package edu.nwu.museum.common.authentication;

import edu.nwu.museum.domain.Permission;
import edu.nwu.museum.domain.Role;
import edu.nwu.museum.domain.User;
import edu.nwu.museum.service.UserPermissionService;
import edu.nwu.museum.service.UserRoleService;
import edu.nwu.museum.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
  @Autowired
  private UserService userService;
  @Autowired
  private UserRoleService userRoleService;
  @Autowired
  private UserPermissionService userPermissionService;

  // 大坑！必须重写此方法，不然 Shiro 会报错！
  @Override
  public boolean supports(AuthenticationToken token) {
    return token instanceof JWTToken;
  }

  /**
   * 只有当需要检测用户权限的时候才会调用此方法，例如 checkRole, checkPermission 之类的
   * @param principal
   * @return simpleAuthorizationInfo
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
    String userId = JWTUtil.getUserId(principal.toString());
    User user = userService.findById(userId);

    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

    // 获取用户角色集
    List<Role> roleList = userRoleService.findByUserId(userId);
    Set<String> roleSet = new HashSet<String>();
    for (Role r: roleList) {
      roleSet.add(r.getName());
    }
    simpleAuthorizationInfo.setRoles(roleSet);

    // 获取用户权限集
    List<Permission> permissionList = userPermissionService.findByUserId(userId);
    Set<String> permissionSet = new HashSet<String>();
    for (Permission p : permissionList) {
      permissionSet.add(p.getName());
    }
    simpleAuthorizationInfo.setStringPermissions(permissionSet);
    return simpleAuthorizationInfo;
  }

  /**
   * 登录认证
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
    // 获取密钥
    String token = (String) authToken.getCredentials();
    // 解密获得 userId, 用于和数据库进行对比
    String userId = JWTUtil.getUserId(token);

    if (userId == null) {
      throw new AuthenticationException("Token invalid.");
    }

    User user = userService.findById(userId);

    if (user == null) {
      throw new UnknownAccountException("This user does not exist.");
    }
    if (! JWTUtil.verify(token, userId, user.getPassword())) {
      throw new AuthenticationException("Wrong password.");
    }
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token, token, "MyRealm");
    return info;
  }
}
