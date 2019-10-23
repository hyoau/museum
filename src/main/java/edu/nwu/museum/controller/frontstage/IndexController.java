package edu.nwu.museum.controller.frontstage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/index")
public class IndexController {
  @RequestMapping("/selected-antique")
  public String selectAntique() {
    return "精选文物";
  }

  @RequestMapping("/museum-list")
  public String listMuseum() {return "博物馆选择";}

  @RequestMapping("/selected-theme")
  public String selectTheme() {
    return "精选主题";
  }
}
