package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Permission;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface PermissionMapper {
    List<Permission> findAll();

    Permission find(String permId);

    void update(Permission permission);

    void delete(String permId);

    void insert(Permission permission);

}
