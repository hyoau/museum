package edu.nwu.museum.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.domain.Museum;
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
public class MuseumMapperTest {
  @Resource
  private MuseumMapper museumMapper;

  @Test
  public void testFindAll() {
    Assert.assertNotNull(museumMapper.findAll());
    System.out.println("====================");
    System.out.println(museumMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testFind() {
    System.out.println("====================");
    System.out.println(museumMapper.find("DGMU001"));
    System.out.println("====================");
    System.out.println("====================");
    System.out.println(museumMapper.find("DGMU002"));
    System.out.println("====================");
  }

  @Test
  public void testInsert() {
    Museum museum = new Museum();
    museum.setMuseumId("8362");
    museum.setMuseumName("Meow");
    museumMapper.insert(museum);
    System.out.println("====================");
    System.out.println(museumMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testDelete() {
    museumMapper.delete("8362");
    System.out.println("====================");
    System.out.println(museumMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testUpdate() {
    Museum museum = new Museum();
    museum.setMuseumId("8362");
    museum.setMuseumName("Joo");
    museumMapper.update(museum);
    System.out.println("====================");
    System.out.println(museumMapper.findAll());
    System.out.println("====================");
  }
}
