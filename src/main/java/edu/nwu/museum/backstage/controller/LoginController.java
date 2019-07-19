package edu.nwu.museum.backstage.controller;

import edu.nwu.museum.common.utils.MD5Util;
import org.apache.shiro.authc.UsernamePasswordToken;
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
    return "login";
  }

  @RequestMapping("/")
  public String redirectIndex() {
    return "redirect:/index";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(String userId, String password) {
    // password = MD5Util.encrypt(userId, password);
    UsernamePasswordToken token = new UsernamePasswordToken(userId, password);
    Subject subject = SecurityUtils.getSubject();
    try {
      subject.login(token);
      return "OK";
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
