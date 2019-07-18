package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.User;
import java.util.List;

public interface UserMapper {
  List<User> findAll();

  User findById(String userId);

  void update(User user);

  void insert(User user);

  int deleteById(String userId);
}
