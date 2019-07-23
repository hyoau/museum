package edu.nwu.museum.frontstage.controller.general;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/search")
public class SearchController {
  @RequestMapping("/")
  public String search() {
    return "搜索接口";
  }
}
