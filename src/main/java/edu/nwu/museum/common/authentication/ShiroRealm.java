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
  /**
   * 获取用户角色和权限
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
    User user = (User) SecurityUtils.getSubject().getPrincipal();
    String userId = user.getUserId();

    System.out.println("用户" + userId + "获取权限-----ShiroRealm.doGetAuthorizationInfo");
    SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

    // 获取用户角色集
    List<Role> roleList = userRoleService.findByUserId(userId);
    Set<String> roleSet = new HashSet<String>();
    for (Role r : roleList) {
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
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    // 获取用户输入的id和密码
    String userId = (String) token.getPrincipal();
    String password = new String((char[]) token.getCredentials());

    System.out.println("用户" + userId + "认证-----ShiroRealm.doGetAuthenticationInfo");

    // 通过用户名到数据库查询用户信息
    User user = userService.findById(userId);

    if (user == null) {
      throw new UnknownAccountException("用户Id或密码错误！");
    }
    if (!password.equals(user.getPassword())) {
      throw new IncorrectCredentialsException("用户ID或密码错误！");
    }
    if (user.getUserStatus().equals("0")) {
      throw new LockedAccountException("账号已被锁定,请联系管理员！");
    }
    SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, password, getName());
    return info;
  }
}
