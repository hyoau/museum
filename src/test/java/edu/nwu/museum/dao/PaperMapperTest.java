package edu.nwu.museum.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.domain.Paper;
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
public class PaperMapperTest {
  @Resource
  private PaperMapper paperMapper;

  @Test
  public void testSelectAll() {
    System.out.println("========testSelectAll========");
    Assert.assertNotNull(paperMapper.findAll());
    for (Paper userIterator: paperMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========testSelectAll========");
  }

  @Test
  public void testSelectById() {
    System.out.println("==========testSelectById==========");
    System.out.println(paperMapper.findById("1"));
    System.out.println(paperMapper.findById("3"));
    System.out.println("==========testSelectById==========");
  }

  @Test
  public void testInsert() {
    Paper paper = new Paper();
    paper.setPaperId("6");
    System.out.println("==========testInsert==========");
    paperMapper.insert(paper);
    for (Paper userIterator: paperMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("==========testInsert==========");
  }

  @Test
  public void testUpdate() {
    Paper paper = new Paper();
    System.out.println("========testUpdate========");
    paper.setPaperId("6");
    paper.setPaperTitle("可视化");
    System.out.println(paperMapper.findById("6"));
    paperMapper.update(paper);
    System.out.println(paperMapper.findById("6"));
    System.out.println("========testUpdate========");
  }

  @Test
  public void testDeleteById() {
    System.out.println("==========testDeleteById==========");
    System.out.println(paperMapper.deleteById("6"));
    for (Paper userIterator: paperMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("==========testDeleteById==========");
  }
}
