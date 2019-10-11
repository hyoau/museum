package edu.nwu.museum.controller.front;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/profile")
public class ProfileController {
  @RequestMapping("/favourite")
  public String favourite() {
    return "收藏";
  }

  @RequestMapping("/comment")
  public String comment() {
    return "评论";
  }

  @RequestMapping("/history")
  public String history() {
    return "浏览足迹";
  }
}
