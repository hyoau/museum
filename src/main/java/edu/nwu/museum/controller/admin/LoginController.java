package edu.nwu.museum.controller.admin;

import edu.nwu.museum.controller.LoginForm;
import edu.nwu.museum.common.response.Response;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @PostMapping("/user/login")
    public Response login(@RequestBody LoginForm loginform) {
        if (loginform.getUsername().equals("admin") && loginform.getPassword().equals("111111")) {
            return new Response(20000, "Login success.", "admin-token");
        } else {
            return new Response(60204, "Account and password are incorrect.", null);
        }
    }

    @GetMapping("/user/info")
    public Response getUserInfo() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("roles", "'admin'");
        data.put("introduction", "I am a super administrator");
        data.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        data.put("name", "Super Admin");
        return new Response(20000, "Login success.", data);
    }
}
