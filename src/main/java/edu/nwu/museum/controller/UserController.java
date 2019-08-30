package edu.nwu.museum.controller;

import edu.nwu.museum.domain.User;
import edu.nwu.museum.service.UserService;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @RequiresPermissions("user:user")
  @RequestMapping("/list")
  public List<User> userList() {
    return userService.findAll();
  }

  @RequiresPermissions("user:add")
  @RequestMapping("/add")
  public List<User> userAdd() {
    User user = new User();
    user.setUserId("8832");
    userService.insert(user);
    return userService.findAll();
  }

  @RequiresPermissions("user:delete")
  @RequestMapping("/delete")
  public List<User> userDelete() {
    userService.deleteById("8832");
    return userService.findAll();
  }
}
