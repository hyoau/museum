package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.backstage.domain.News;
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
    System.out.println(newsMapper.findAll());
    System.out.println(newsMapper.findAll().size());
  }

  @Test
  public void testSelectById() {

    System.out.println("==========testSelectById==========");
    Assert.assertNotNull(newsMapper.findByNewsId("1"));
    System.out.println(newsMapper.findByNewsId("1"));
  }

  @Test
  public void testInsert() {
    News news = new News();
    System.out.println("========testSelectAll========");
    System.out.println(newsMapper.findAll());
    System.out.println(newsMapper.findAll().size());
    news.setNewsId("7");
    System.out.println("==========testInsert==========");
    System.out.println(newsMapper.insert(news));
    System.out.println("========testSelectById========");
    System.out.println(newsMapper.findByNewsId("7"));
  }

  @Test
  public void testUpdateById() {
    News news = new News();
    System.out.println("========testSelectAll========");
    System.out.println(newsMapper.findAll());
    System.out.println(newsMapper.findAll().size());
    news.setNewsId("6");
    news.setNewsTitle("人生啊~~~~~");
    System.out.println("==========testUpdateById==========");
    System.out.println(newsMapper.update(news));
    System.out.println("========testSelectById========");
    System.out.println(newsMapper.findByNewsId("6"));
  }

  @Test
  public void testDeleteById() {

    System.out.println("==========testDeleteById==========");
    System.out.println(newsMapper.deleteByNewsId("1"));
  }
}
















































