package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Permission;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPermissionMapper {
  List<Permission> findByUserId(String userId);
}
