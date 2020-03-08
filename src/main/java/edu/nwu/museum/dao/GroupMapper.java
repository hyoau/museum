package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Group;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface GroupMapper {
    List<Group> findAll();

    Group find(String groupId);

    void update(Group group);

    void delete(String groupId);

    void insert(Group group);
}
