package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Group;
import edu.nwu.museum.backstage.domain.Permission;
import java.util.List;

public interface PermissionMapper {
  List<Permission> findAll();

  Permission find(String permId);

  void update(Permission permission);

  void delete(String permId);

  void insert(Permission permission);

}
