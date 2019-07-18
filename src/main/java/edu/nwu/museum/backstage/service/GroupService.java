package edu.nwu.museum.backstage.service;

import edu.nwu.museum.backstage.dao.GroupMapper;
import edu.nwu.museum.backstage.domain.Group;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupService {
  @Autowired
  GroupMapper groupMapper;

  public List<Group> findAll() {
    return groupMapper.findAll();
  }

  public Group findById(String groupId) {
    return groupMapper.find(groupId);
  }

  public void insert(Group group) {
    groupMapper.insert(group);
  }

  public void update(Group group) {
    groupMapper.update(group);
  }

  public void delete(String groupId) {
    groupMapper.delete(groupId);
  }
}
