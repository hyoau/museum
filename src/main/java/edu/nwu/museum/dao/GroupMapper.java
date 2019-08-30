package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Group;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupMapper {
  List<Group> findAll();

  Group find(String groupId);

  void update(Group group);

  void delete(String groupId);

  void insert(Group group);
}
