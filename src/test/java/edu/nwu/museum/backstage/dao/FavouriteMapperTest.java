package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.backstage.domain.Favourite;
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
public class FavouriteMapperTest {
  @Resource
  private FavouriteMapper favouriteMapper;

  @Test
  public void testFindAll() {
    Assert.assertNotNull(favouriteMapper.findAll());
    System.out.println("====================");
    System.out.println(favouriteMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testFind() {
    System.out.println("====================");
    System.out.println(favouriteMapper.find(1));
    System.out.println("====================");
    System.out.println("====================");
    System.out.println(favouriteMapper.find(2));
    System.out.println("====================");
  }

  @Test
  public void testInsert() {
    Favourite favourite = new Favourite();
    favourite.setSeqNo(8362);
    favourite.setAntiqueId("Meow");
    favouriteMapper.insert(favourite);
    System.out.println("====================");
    System.out.println(favouriteMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testDelete() {
    favouriteMapper.delete(8362);
    System.out.println("====================");
    System.out.println(favouriteMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testUpdate() {
    Favourite favourite = new Favourite();
    favourite.setSeqNo(8362);
    favourite.setAntiqueId("Joo");
    favouriteMapper.update(favourite);
    System.out.println("====================");
    System.out.println(favouriteMapper.findAll());
    System.out.println("====================");
  }
}
