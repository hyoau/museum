package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.backstage.domain.Paper;
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
    System.out.println(paperMapper.findAll());
    System.out.println(paperMapper.findAll().size());
  }

  @Test
  public void testSelectById() {
    System.out.println("==========testSelectById==========");
    Assert.assertNotNull(paperMapper.findByPaperId("1"));
    System.out.println(paperMapper.findByPaperId("1"));
  }

  @Test
  public void testInsert() {
    Paper paper = new Paper();
    paper.setPaperId("6");
    System.out.println(paperMapper.findAll());
    System.out.println("==========testInsert==========");
    System.out.println(paperMapper.insert(paper));
    System.out.println("========testSelectById========");
    System.out.println(paperMapper.findAll());
  }

  @Test
  public void testUpdate() {
    Paper paper = new Paper();
    System.out.println("========testSelectAll========");
    System.out.println(paperMapper.findAll());
    System.out.println(paperMapper.findAll().size());
    paper.setPaperId("4");
    paper.setPaperTitle("可视化");
    System.out.println("==========testUpdateById==========");
    System.out.println(paperMapper.update(paper));
    System.out.println("========testSelectById========");
    System.out.println(paperMapper.findByPaperId("4"));
  }

  @Test
  public void testDeleteById() {

    System.out.println("==========testDeleteById==========");
    System.out.println(paperMapper.deleteByPaperId("4"));
    System.out.println("========testSelectAll========");
    System.out.println(paperMapper.findAll());
  }
}
