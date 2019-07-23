package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.backstage.domain.Antique;
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
public class AntiqueMapperTest {

  @Resource
  private AntiqueMapper antiqueMapper;

  @Test
  public void testSelectAll() {
    System.out.println("========testSelectAll========");
    Assert.assertNotNull(antiqueMapper.findAll());
    System.out.println(antiqueMapper.findAll());
    System.out.println(antiqueMapper.findAll().size());
  }

  @Test
  public void testSelectById() {

    System.out.println("==========testSelectById==========");
    System.out.println(antiqueMapper.findById("5",5));
  }

  @Test
  public void testInsert() {
    Antique antique = new Antique();
    System.out.println("========testSelectAll========");
    System.out.println(antiqueMapper.findAll().size());
    antique.setAntiqueId("5");
    antique.setSeqNo(5);
    antique.setAntiqueName("可视化研究所");
    System.out.println("==========testInsert==========");
    antiqueMapper.insert(antique);
    System.out.println("========testSelectById========");
    System.out.println(antiqueMapper.findById("5",5));
  }

  @Test
  public void testUpdateById() {
    Antique antique = new Antique();
    System.out.println("========testSelectById========");
    System.out.println(antiqueMapper.findById("5",5));
    antique.setAntiqueId("5");
    antique.setSeqNo(5);
    antique.setAntiqueName("人生啊~~~~~");
    System.out.println("==========testUpdateById==========");
    antiqueMapper.update(antique);
    System.out.println("========testSelectById========");
    System.out.println(antiqueMapper.findById("5",5));
  }

  @Test
  public void testDeleteById() {
    System.out.println("========testSelectAll========");
    System.out.println(antiqueMapper.findAll());
    System.out.println(antiqueMapper.findAll().size());
    System.out.println("==========testDeleteById==========");
    antiqueMapper.deleteById("5");
    System.out.println(antiqueMapper.findAll());
    System.out.println(antiqueMapper.findAll().size());
  }
}
