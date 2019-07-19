package edu.nwu.museum.backstage.service;

import edu.nwu.museum.backstage.dao.UserPermissionMapper;
import edu.nwu.museum.backstage.domain.Permission;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionService {
  @Autowired
  UserPermissionMapper userPermissionMapper;

  public List<Permission> findByUserId(String userId) {
    return userPermissionMapper.findByUserId(userId);
  }
}
