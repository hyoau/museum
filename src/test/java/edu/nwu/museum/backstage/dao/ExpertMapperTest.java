package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.backstage.domain.Expert;
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
public class ExpertMapperTest {
  @Resource
  private ExpertMapper expertMapper;

  @Test
  public void testSelectAll() {
    System.out.println("========testSelectAll========");
    Assert.assertNotNull(expertMapper.findAll());
    for (Expert userIterator: expertMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========testSelectAll========");
  }

  @Test
  public void testSelectById() {

    System.out.println("==========testSelectById==========");
    System.out.println(expertMapper.findById("1"));
    System.out.println(expertMapper.findById("3"));
    System.out.println("==========testSelectById==========");
  }

  @Test
  public void testInsert() {
    System.out.println("==========testInsert==========");
    Expert expert = new Expert();
    expert.setExpertId("4");
    expertMapper.insert(expert);
    for (Expert userIterator: expertMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("==========testInsert==========");
  }

  @Test
  public void testUpdateById() {
    System.out.println("========testUpdateById========");
    System.out.println(expertMapper.findById("4"));
    Expert expert = new Expert();
    expert.setExpertId("4");
    expert.setExpertName("可视化");
    expertMapper.update(expert);
    System.out.println(expertMapper.findById("4"));
    System.out.println("==========testUpdateById==========");
  }

  @Test
  public void testDeleteById() {
    System.out.println("==========testDeleteById==========");
    System.out.println(expertMapper.deleteById("4"));
    for (Expert userIterator: expertMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("==========testDeleteById==========");
  }
}
