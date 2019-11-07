package edu.nwu.museum.dao;

import edu.nwu.museum.MuseumApplication;
import edu.nwu.museum.domain.Comment;
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
public class CommentMapperTest {
  @Resource
  private CommentMapper commentMapper;

  @Test
  public void testFindAll() {
    Assert.assertNotNull(commentMapper.findAll());
    System.out.println("====================");
    System.out.println(commentMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testFind() {
    System.out.println("====================");
    System.out.println(commentMapper.find(1));
    System.out.println("====================");
    System.out.println("====================");
    System.out.println(commentMapper.find(2));
    System.out.println("====================");
  }

  @Test
  public void testInsert() {
    Comment comment = new Comment();
    comment.setAntiqueId("Meow");
    comment.setCommentSeqNo(8888);
    comment.setCommentContent("Meow");
    commentMapper.insert(comment);
    System.out.println("====================");
    System.out.println(commentMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testUpdate() {
    Comment comment = commentMapper.find(1);
    comment.setCommentSeqNo(8888);
    comment.setCommentContent("Joo");
    commentMapper.update(comment);
    System.out.println("====================");
    System.out.println(commentMapper.findAll());
    System.out.println("====================");
  }

  @Test
  public void testDelete() {
    commentMapper.delete(8888);
    System.out.println("====================");
    System.out.println(commentMapper.findAll());
    System.out.println("====================");
  }
}
