package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Role;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
  List<Role> findByUserId(String userId);
}
