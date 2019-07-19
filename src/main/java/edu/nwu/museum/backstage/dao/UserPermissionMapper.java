package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Permission;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionMapper {
  List<Permission> findByUserId(String userId);
}
