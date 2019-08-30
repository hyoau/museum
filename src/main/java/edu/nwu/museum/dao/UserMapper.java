package edu.nwu.museum.dao;

import edu.nwu.museum.domain.User;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
  List<User> findAll();

  User findById(String userId);

  void update(User user);

  void insert(User user);

  int deleteById(String userId);
}
