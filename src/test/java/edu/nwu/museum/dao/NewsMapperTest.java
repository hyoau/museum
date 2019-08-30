package edu.nwu.museum.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.domain.News;
import javax.annotation.Resource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MuseumApplication.class)
@EnableAutoConfiguration
public class NewsMapperTest {
  @Resource
  private NewsMapper newsMapper;

  @Test
  public void testSelectAll() {
    System.out.println("========testSelectAll========");
    Assert.assertNotNull(newsMapper.findAll());
    for (News userIterator: newsMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========testSelectAll========");
  }

  @Test
  public void testSelectById() {

    System.out.println("==========testSelectById==========");
    System.out.println(newsMapper.findById("1"));
    System.out.println(newsMapper.findById("3"));
    System.out.println("==========testSelectById==========");
  }

  @Test
  public void testInsert() {
    System.out.println("==========testInsert==========");
    News news = new News();
    news.setNewsId("12");
    news.setNewsTitle("红酥手");
    newsMapper.insert(news);
    for (News userIterator: newsMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("==========testInsert==========");
  }

  @Test
  public void testUpdateById() {
    System.out.println("========testUpdateById========");
    News news = new News();
    news.setNewsId("12");
    news.setNewsTitle("黄縢酒");
    System.out.println(newsMapper.findById("12"));
    newsMapper.update(news);
    System.out.println(newsMapper.findById("12"));
    System.out.println("==========testUpdateById==========");
  }

  @Test
  public void testDeleteById() {

    System.out.println("==========testDeleteById==========");
    newsMapper.deleteById("12");
    for (News userIterator: newsMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("==========testDeleteById==========");
  }
}
















































