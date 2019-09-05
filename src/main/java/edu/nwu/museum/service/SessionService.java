package edu.nwu.museum.service;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
  @Autowired
  private SessionDAO sessionDAO;

  public boolean isOnline(String sessionId) {
    Session session = sessionDAO.readSession(sessionId);
    Long timeout = session.getTimeout();
    if(timeout == 0) {
      return false;
    } else return true;
  }

  public boolean forceLogout(String sessionId) {
    Session session = sessionDAO.readSession(sessionId);
    session.setTimeout(0);
    return true;
  }
}
