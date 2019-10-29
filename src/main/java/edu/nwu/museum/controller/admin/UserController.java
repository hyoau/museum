package edu.nwu.museum.controller.admin;

import edu.nwu.museum.common.response.Response;
import edu.nwu.museum.domain.User;
import edu.nwu.museum.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @RequestMapping("/api/user/create")
  public Response createUser(@RequestBody HashMap<String, User> request) {
    log.info("Create user");
    User user = request.get("user");
    log.info("User: " + user + " is created");
    userService.insert(user);
    return new Response(20000, "创建新用户成功", null);
  }

  @RequestMapping(value = "/api/user/list", method = RequestMethod.GET)
  public Response getUserList(@RequestParam("offset") Integer offset) {
    ArrayList<User> users = new ArrayList<>(userService.paginate(offset));
    HashMap<String, Object> data = new HashMap<>();
    data.put("users", users);
    return new Response(20000, "SUCCESS", data);
  }
}
