package edu.nwu.museum.backstage.service;

import edu.nwu.museum.backstage.dao.UserMapper;
import edu.nwu.museum.backstage.domain.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
  @Autowired
  UserMapper userMapper;

  public List<User> findAll() {
    return userMapper.findAll();
  }

  public User findById(String userId) {
    return userMapper.findById(userId);
  }

  public void insert(User user) {
    userMapper.insert(user);
  }

  public void update(User user) {
    userMapper.update(user);
  }

  public void deleteById(String userId) {
    userMapper.deleteById(userId);
  }
}
