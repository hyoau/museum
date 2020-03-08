package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Comment;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface CommentMapper {
    List<Comment> findAll();

    Comment find(Integer commentSeqNo);

    void update(Comment comment);

    void delete(Integer commentSeqNo);

    void insert(Comment comment);
}
