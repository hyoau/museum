package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MuseumApplication.class)
@EnableAutoConfiguration
public class GroupMapperTest {
  @Resource
  private GroupMapper groupMapper;

  @Test
  public void testSelectAllGroup() {
    Assert.assertNotNull(groupMapper.findAllGroup());
    System.out.println(groupMapper.findAllGroup());
  }
}
