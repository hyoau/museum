package edu.nwu.museum.controller;

import edu.nwu.museum.common.jwt.JWTUtil;
import edu.nwu.museum.common.response.Response;
import edu.nwu.museum.domain.User;
import edu.nwu.museum.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  @Autowired
  UserService userService;

  @PostMapping("/api/test/login")
  public Response login(@RequestParam("userId") String userId,
      @RequestParam("password") String password) {
    User user = userService.findById(userId);
    if (user.getPassword().equals(password)) {
      return new Response(200, "Login success.", JWTUtil.sign(userId, password));
    } else throw new RuntimeException();
  }

  @GetMapping("/api/test/auth")
  @RequiresAuthentication
  public Response auth() {
    return new Response(200, "You are authenticated.", null);
  }
}
