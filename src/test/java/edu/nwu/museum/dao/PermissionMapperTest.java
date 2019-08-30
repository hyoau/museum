package edu.nwu.museum.dao;

import edu.nwu.museum.MuseumApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MuseumApplication.class)
@EnableAutoConfiguration
public class PermissionMapperTest {
//  @Resource
//  private PermissionMapper permissionMapper;
//
//  @Test
//  public void testFindAll() {
//    Assert.assertNotNull(permissionMapper.findAll());
//    System.out.println("====================");
//    System.out.println(permissionMapper.findAll());
//    System.out.println("====================");
//  }
//
//  @Test
//  public void testFind() {
//    System.out.println("====================");
//    System.out.println(permissionMapper.find("1"));
//    System.out.println("====================");
//    System.out.println("====================");
//    System.out.println(permissionMapper.find("2"));
//    System.out.println("====================");
//  }
//
//  @Test
//  public void testInsert() {
//    Permission permission = new Permission();
//    permission.setPermId("8362");
//    permission.setPermName("Meow");
//    permissionMapper.insert(permission);
//    System.out.println("====================");
//    System.out.println(permissionMapper.findAll());
//    System.out.println("====================");
//  }
//
//  @Test
//  public void testDelete() {
//    permissionMapper.delete("8362");
//    System.out.println("====================");
//    System.out.println(permissionMapper.findAll());
//    System.out.println("====================");
//  }
//
//  @Test
//  public void testUpdate() {
//    Permission permission = new Permission();
//    permission.setPermId("8362");
//    permission.setPermName("Joo");
//    permissionMapper.update(permission);
//    System.out.println("====================");
//    System.out.println(permissionMapper.findAll());
//    System.out.println("====================");
//  }
}
