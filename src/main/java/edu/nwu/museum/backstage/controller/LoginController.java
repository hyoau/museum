package edu.nwu.museum.backstage.controller;

import edu.nwu.museum.common.utils.MD5Util;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;

@RestController
public class LoginController {
  @RequestMapping("/login")
  public String login() {
    return "Login";
  }

  @RequestMapping("/")
  public String redirectIndex() {
    return "Index";
  }

  @RequestMapping("/test")
  public String test() {
    return "Test";
  }

  @CrossOrigin
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(String userId, String password, Boolean rememberMe) {
    // 暂时先用明文来存储密码
    UsernamePasswordToken token = new UsernamePasswordToken(userId, password, rememberMe);
    Subject subject = SecurityUtils.getSubject();
    try {
      subject.login(token);
      return "认证成功";
    } catch (UnknownAccountException e) {
      return "认证失败";
    } catch (IncorrectCredentialsException e) {
      return "认证失败";
    } catch (LockedAccountException e) {
      return "认证失败";
    } catch (AuthenticationException e) {
      return "认证失败";
    }
  }
}
