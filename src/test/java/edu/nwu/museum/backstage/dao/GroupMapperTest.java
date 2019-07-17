package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.backstage.domain.Group;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MuseumApplication.class)
@EnableAutoConfiguration
public class GroupMapperTest {
  @Resource
  private GroupMapper groupMapper;

  @Test
  public void testFindAll() {
    Assert.assertNotNull(groupMapper.findAll());
    System.out.println("====================");
    System.out.println(groupMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testFind() {
    System.out.println("====================");
    System.out.println(groupMapper.find("1"));
    System.out.println("====================");
    System.out.println("====================");
    System.out.println(groupMapper.find("2"));
    System.out.println("====================");
  }

  @Test
  public void testInsert() {
    Group group = new Group();
    group.setGroupId("8362");
    group.setGroupName("Meow");
    groupMapper.insert(group);
    System.out.println("====================");
    System.out.println(groupMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testDelete() {
    groupMapper.delete("8362");
    System.out.println("====================");
    System.out.println(groupMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testUpdate() {
    Group group = new Group();
    group.setGroupId("8362");
    group.setGroupName("Joo");
    groupMapper.update(group);
    System.out.println("====================");
    System.out.println(groupMapper.findAll());
    System.out.println("====================");
  }
}
