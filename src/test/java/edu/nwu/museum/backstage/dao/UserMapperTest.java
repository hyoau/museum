package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.backstage.domain.User;
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
public class UserMapperTest {
  @Resource
  private UserMapper userMapper;

  @Test
  public void testFindAll() {
    Assert.assertNotNull(userMapper.findAll());
    System.out.println("========== UserMapper Test ==========");
    for (User userIterator: userMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testFind() {
    System.out.println("========== UserMapper Test ==========");
    System.out.println(userMapper.findById("1"));
    System.out.println("========== UserMapper Test ==========");
    System.out.println("========== UserMapper Test ==========");
    System.out.println(userMapper.findById("2"));
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testInsert() {
    User user = new User();
    user.setUserId("8362");
    user.setUserName("Meow");
    userMapper.insert(user);
    System.out.println("========== UserMapper Test ==========");
    for (User userIterator: userMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testDeleteById() {
    userMapper.deleteById("8362");
    System.out.println("========== UserMapper Test ==========");
    for (User userIterator: userMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testUpdate() {
    User user = new User();
    user.setUserId("8362");
    user.setUserName("Joo");
    userMapper.update(user);
    System.out.println("========== UserMapper Test ==========");
    System.out.println(userMapper.findById("8362"));
    System.out.println("========== UserMapper Test ==========");
  }
}
