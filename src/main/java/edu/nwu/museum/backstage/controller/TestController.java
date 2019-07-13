package edu.nwu.museum.backstage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Slf4j
@Controller
@RequestMapping("/")
public class TestController {
  @RequestMapping(value = "hello")
  String sayHi(Model model) {
    for(int i = 0; i < 10; i++) {
      Integer message = i;
      log.info(message.toString());
    }
    return "hello";
  }
}
