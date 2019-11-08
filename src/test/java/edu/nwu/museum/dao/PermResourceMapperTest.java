package edu.nwu.museum.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.domain.PermResource;
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
public class PermResourceMapperTest {
  @Resource
  private PermResourceMapper permResourceMapper;

  @Test
  public void testFindAll() {
    Assert.assertNotNull(permResourceMapper.findAll());
    System.out.println("====================");
    System.out.println(permResourceMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testFind() {
    System.out.println("====================");
    System.out.println(permResourceMapper.find("1"));
    System.out.println("====================");
    System.out.println("====================");
    System.out.println(permResourceMapper.find("2"));
    System.out.println("====================");
  }

  @Test
  public void testInsert() {
    PermResource permResource = new PermResource();
    permResource.setPermResId("8362");
    permResource.setPermResName("小笨蛋");
    permResourceMapper.insert(permResource);
    System.out.println("====================");
    System.out.println(permResourceMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testUpdate() {
    PermResource permResource = permResourceMapper.find("8362");
    permResource.setPermResId("8362");
    permResource.setPermResName("Joo");
    permResourceMapper.update(permResource);
    System.out.println("====================");
    System.out.println(permResourceMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testDelete() {
    permResourceMapper.delete("8362");
    System.out.println("====================");
    System.out.println(permResourceMapper.findAll());
    System.out.println("====================");
  }
}
