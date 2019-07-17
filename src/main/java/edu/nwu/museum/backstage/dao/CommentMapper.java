package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Comment;
import java.util.List;

public interface CommentMapper {
  List<Comment> findAll();

  Comment find(Integer commentSeqNo);

  void update(Comment comment);

  void delete(Integer commentSeqNo);

  void insert(Comment comment);
}
