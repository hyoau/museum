package edu.nwu.museum.dao;

import edu.nwu.museum.domain.User;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper {
    List<User> paginate(Integer offset);

    List<User> findAll();

    User findById(String userId);

    void update(User user);

    void insert(User user);

    int deleteById(String userId);
}
