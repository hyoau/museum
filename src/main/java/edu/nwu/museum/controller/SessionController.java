package edu.nwu.museum.controller;

import edu.nwu.museum.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {
  @Autowired
  SessionService sessionService;

  @RequestMapping("/test-online")
  public Boolean testOnline(@RequestParam("session-id") String sessionId) {
    return sessionService.isOnline(sessionId);
  }

  @RequestMapping("/force-logout")
  public void logout(@RequestParam("session-id") String sessionId) {
    try {
      sessionService.forceLogout(sessionId);
    } catch (Exception e) {
    }
  }
}
