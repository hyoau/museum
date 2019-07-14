package edu.nwu.museum.backstage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.nwu.museum.backstage.domain.User;

public interface UserMapper extends BaseMapper<User> {
  User findByUserName(String userName);
}