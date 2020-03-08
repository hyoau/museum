package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Topic;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface TopicMapper {
    List<Topic> findAll();

    Topic findById(String topicId);

    void update(Topic topic);

    void deleteById(String topicId);

    void insert(Topic topic);
}
