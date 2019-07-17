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
    System.out.println(expertMapper.findAll());
    System.out.println(expertMapper.findAll().size());
  }

  @Test
  public void testSelectById() {

    System.out.println("==========testSelectById==========");
    Assert.assertNotNull(expertMapper.findByExpertId("1"));
    System.out.println(expertMapper.findByExpertId("1"));
  }

  @Test
  public void testInsert() {
    Expert expert = new Expert();
    expert.setExpertId("4");
    System.out.println("==========test==========");
    System.out.println(expert);
    System.out.println("==========testInsert==========");
    System.out.println(expertMapper.insert(expert));
    System.out.println("========testSelectById========");
    System.out.println(expertMapper.findByExpertId("4"));
  }

  @Test
  public void testUpdateById() {
    Expert expert = new Expert();
    System.out.println("========testSelectAll========");
    System.out.println(expertMapper.findAll());
    System.out.println(expertMapper.findAll().size());
    expert.setExpertId("4");
    expert.setExpertName("可视化");
    System.out.println("==========testUpdateById==========");
    System.out.println(expertMapper.update(expert));
    System.out.println("========testSelectById========");
    System.out.println(expertMapper.findByExpertId("4"));
  }

  @Test
  public void testDeleteById() {

    System.out.println("==========testDeleteById==========");
    System.out.println(expertMapper.deleteByExpertId("4"));
    System.out.println("========testSelectAll========");
    System.out.println(expertMapper.findAll());
  }
}
