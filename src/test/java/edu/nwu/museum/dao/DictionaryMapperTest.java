package edu.nwu.museum.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.domain.Dictionary;
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
public class DictionaryMapperTest {
  @Resource
  private DictionaryMapper dictionaryMapper;

  @Test
  public void testFindAll() {
    Assert.assertNotNull(dictionaryMapper.findAll());
    System.out.println("========== UserMapper Test ==========");
    for (Dictionary userIterator: dictionaryMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testFind() {
    System.out.println("========== UserMapper Test ==========");
    System.out.println(dictionaryMapper.findById("mu_level", 1));
    System.out.println("========== UserMapper Test ==========");
    System.out.println("========== UserMapper Test ==========");
    System.out.println(dictionaryMapper.findById("mu_level", 2));
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testInsert() {
    Dictionary dictionary = new Dictionary();
    dictionary.setDictCode("mu_level");
    dictionary.setDictItemCode(4);
    dictionaryMapper.insert(dictionary);
    System.out.println("========== UserMapper Test ==========");
    for (Dictionary userIterator: dictionaryMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testUpdate() {
    Dictionary dictionary = new Dictionary();
    dictionary.setDictCode("mu_level");
    dictionary.setDictItemCode(4);
    dictionary.setDictName("可视化研究所");
    dictionaryMapper.update(dictionary);
    System.out.println("========== UserMapper Test ==========");
    System.out.println(dictionaryMapper.findById("mu_level", 4));
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testDeleteById() {
    dictionaryMapper.deleteById("mu_level", 4);
    System.out.println("========== UserMapper Test ==========");
    for (Dictionary userIterator: dictionaryMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========== UserMapper Test ==========");
  }
}
