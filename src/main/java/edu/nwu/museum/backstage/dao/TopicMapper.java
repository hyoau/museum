package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Topic;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicMapper {
  List<Topic> findAll();

  Topic findById(String topicId);

  void update(Topic topic);

  void deleteById(String topicId);

  void insert(Topic topic);
}
