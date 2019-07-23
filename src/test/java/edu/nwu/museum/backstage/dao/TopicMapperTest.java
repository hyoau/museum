package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.backstage.domain.Topic;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MuseumApplication.class)
@EnableAutoConfiguration
public class TopicMapperTest {
  @Autowired
  TopicMapper topicMapper;

  @Test
  public void testFindAll() {
    Assert.assertNotNull(topicMapper.findAll());
    System.out.println("========== TopicMapper Test ==========");
    for (Topic topicIterator: topicMapper.findAll()) {
      System.out.println(topicIterator);
    }
    System.out.println("========== TopicMapper Test ==========");
  }

  @Test
  public void testFindById() {
    System.out.println("========== TopicMapper Test ==========");
    System.out.println(topicMapper.findById("1"));
    System.out.println("========== TopicMapper Test ==========");
    System.out.println("========== TopicMapper Test ==========");
    System.out.println(topicMapper.findById("2"));
    System.out.println("========== TopicMapper Test ==========");
  }

  @Test
  public void testInsert() {
    Topic topic = new Topic();
    topic.setTopicId("8362");
    topic.setTopicName("一亩清阴，半天潇洒松窗午");
    topicMapper.insert(topic);
    System.out.println("========== TopicMapper Test ==========");
    for (Topic topicIterator: topicMapper.findAll()) {
      System.out.println(topicIterator);
    }
    System.out.println("========== TopicMapper Test ==========");
  }

  @Test
  public void testUpdate() {
    Topic topic = new Topic();
    topic.setTopicId("8362");
    topic.setTopicName("恰似一江春水向东流");
    topicMapper.update(topic);
    System.out.println("========== TopicMapper Test ==========");
    System.out.println(topicMapper.findById("8362"));
    System.out.println("========== TopicMapper Test ==========");
  }

  @Test
  public void testDeleteById() {
    topicMapper.deleteById("8362");
    System.out.println("========== TopicMapper Test ==========");
    for (Topic topicIterator: topicMapper.findAll()) {
      System.out.println(topicIterator);
    }
    System.out.println("========== TopicMapper Test ==========");
  }
}
