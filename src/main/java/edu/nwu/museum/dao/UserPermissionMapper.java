package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Permission;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserPermissionMapper {
  List<Permission> findByUserId(String userId);
}
