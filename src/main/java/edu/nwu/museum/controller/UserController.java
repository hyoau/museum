package edu.nwu.museum.controller;

import edu.nwu.museum.domain.Request;
import edu.nwu.museum.domain.Response;
import edu.nwu.museum.domain.User;
import edu.nwu.museum.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
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

  @CrossOrigin("*")
  @RequestMapping("/api/user/create")
  public Response createUser(@RequestBody HashMap<String, User> request) {
    log.info("Create user");
    User user = request.get("user");
    log.info("User: " + user + " is created");
    userService.insert(user);
    return new Response(20000, "创建新用户成功", null);
  }

  @CrossOrigin("*")
  @RequestMapping(value = "/api/user/list", method = RequestMethod.GET)
  public Response getUserList(@RequestParam("offset") Integer offset) {
    ArrayList<User> users = new ArrayList<>(userService.paginate(offset));
    HashMap<String, Object> data = new HashMap<>();
    for (User user: users) {
      data.put("users", users);
    }
    return new Response(20000, "SUCCESS", data);
  }
}
