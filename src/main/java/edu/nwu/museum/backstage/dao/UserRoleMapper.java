package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Role;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
  List<Role> findByUserId(String userId);
}
