package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Paper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface PaperMapper {
  //查询所有论文信息
  List<Paper> findAll();
  //根据ID查询论文信息
  Paper findById(String paperId);
  //修改论文信息
  void update(Paper paper);
  //添加论文
  void insert(Paper paper);
  //根据ID删除论文
  int deleteById(String paperId);
}
