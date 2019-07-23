package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.backstage.domain.Backup;
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
public class BackupMapperTest {
  @Resource
  private BackupMapper backupMapper;

  @Test
  public void testFindAll() {
    Assert.assertNotNull(backupMapper.findAll());
    System.out.println("========== UserMapper Test ==========");
    for (Backup userIterator: backupMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testFind() {
    System.out.println("========== UserMapper Test ==========");
    System.out.println(backupMapper.findById(1));
    System.out.println("========== UserMapper Test ==========");
    System.out.println("========== UserMapper Test ==========");
    System.out.println(backupMapper.findById(2));
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testInsert() {
    Backup backup = new Backup();
    backup.setSeqNo(4);
    backupMapper.insert(backup);
    System.out.println("========== UserMapper Test ==========");
    for (Backup userIterator: backupMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testUpdate() {
    Backup backup = new Backup();
    backup.setSeqNo(4);
    backup.setUserName("可视化");
    backupMapper.update(backup);
    System.out.println("========== UserMapper Test ==========");
    System.out.println(backupMapper.findById(4));
    System.out.println("========== UserMapper Test ==========");
  }

  @Test
  public void testDeleteById() {
    backupMapper.deleteById(4);
    System.out.println("========== UserMapper Test ==========");
    for (Backup userIterator: backupMapper.findAll()) {
      System.out.println(userIterator);
    }
    System.out.println("========== UserMapper Test ==========");
  }

}
