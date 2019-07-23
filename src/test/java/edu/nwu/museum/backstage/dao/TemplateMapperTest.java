package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.backstage.domain.Template;
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
public class TemplateMapperTest {
  @Resource
  private TemplateMapper templateMapper;

  @Test
  public void testFindAll() {
    Assert.assertNotNull(templateMapper.findAll());
    System.out.println("====================");
    System.out.println(templateMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testFind() {
    System.out.println("====================");
    System.out.println(templateMapper.find("1"));
    System.out.println("====================");
    System.out.println("====================");
    System.out.println(templateMapper.find("2"));
    System.out.println("====================");
  }

  @Test
  public void testInsert() {
    Template template = new Template();
    template.setTemplateId("8362");
    template.setTemplateName("Meow");
    templateMapper.insert(template);
    System.out.println("====================");
    System.out.println(templateMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testDelete() {
    templateMapper.delete("8362");
    System.out.println("====================");
    System.out.println(templateMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testUpdate() {
    Template template = new Template();
    template.setTemplateId("8362");
    template.setTemplateName("Joo");
    templateMapper.update(template);
    System.out.println("====================");
    System.out.println(templateMapper.findAll());
    System.out.println("====================");
  }
}
