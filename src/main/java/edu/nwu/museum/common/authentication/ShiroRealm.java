package edu.nwu.museum.common.authentication;

import edu.nwu.museum.backstage.domain.User;
import edu.nwu.museum.backstage.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
  @Autowired
  private UserService userService;

  /**
   * 获取用户角色和权限
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
    return null;
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
