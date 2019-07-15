package edu.nwu.museum.frontstage.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
  public String index() {
    return "Hello, world!";
  }
}
