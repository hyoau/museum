package edu.nwu.museum.dao;


import edu.nwu.museum.MuseumApplication;
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
public class LogMapperTest {
  @Resource
  private LogMapper logMapper;

  @Test
  public void testSelectAllLog(){
    Assert.assertNotNull(logMapper.findAll());
    System.out.println("==========");
    System.out.println(logMapper.findAll());
    System.out.println("==========");
  }

  @Test
  public void testSelect(){
    System.out.println("==========");
    System.out.println(logMapper.find(1));
    System.out.println("==========");
    System.out.println("==========");
    System.out.println(logMapper.find(2));
    System.out.println("==========");
  }
}
