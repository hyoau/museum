package edu.nwu.museum.service;

import edu.nwu.museum.dao.GroupMapper;
import edu.nwu.museum.domain.Group;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
