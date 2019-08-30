package edu.nwu.museum.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.domain.Antique;
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
    for (Antique userIterator: antiqueMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========testSelectAll========");
  }

  @Test
  public void testSelectById() {

    System.out.println("==========testSelectById==========");
    System.out.println(antiqueMapper.findById("1",1));
    System.out.println(antiqueMapper.findById("3",3));
    System.out.println("==========testSelectById==========");
  }

  @Test
  public void testInsert() {
    Antique antique = new Antique();
    System.out.println("========testInsert========");
    antique.setAntiqueId("5");
    antique.setSeqNo(5);
    antique.setAntiqueName("可视化研究所");
    antiqueMapper.insert(antique);
    for (Antique userIterator: antiqueMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========testInsert========");
  }

  @Test
  public void testUpdateById() {
    Antique antique = new Antique();
    System.out.println("========testUpdateById========");
    System.out.println(antiqueMapper.findById("5",5));
    antique.setAntiqueId("5");
    antique.setSeqNo(5);
    antique.setAntiqueName("人生啊~~~~~");
    System.out.println("==========update==========");
    antiqueMapper.update(antique);
    System.out.println(antiqueMapper.findById("5",5));
    System.out.println("==========testUpdateById==========");

  }

  @Test
  public void testDeleteById() {
    System.out.println("========testDeleteById========");
    antiqueMapper.deleteById("5",5);
    for (Antique userIterator: antiqueMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("==========testDeleteById==========");
  }
}
