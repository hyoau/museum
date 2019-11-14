package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Role;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserRoleMapper {
  List<Role> findByUserId(String userId);
}
