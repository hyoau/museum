package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Group;
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
