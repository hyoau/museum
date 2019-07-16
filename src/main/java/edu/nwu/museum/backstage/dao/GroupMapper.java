package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Group;
import java.util.List;

public interface GroupMapper{
  List<Group> findAllGroup();

  Group findGroupById();

  void updateById(Group group);

  void deleteById(String groupId);

  void insertById(Group group);
}
