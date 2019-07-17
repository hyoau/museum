package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Paper;
import java.util.List;

public interface PaperMapper {
  //查询所有论文信息
  List<Paper> findAll();
  //根据ID查询论文信息
  Paper findByPaperId(String paperId);
  //修改论文信息
  int update(Paper paper);
  //添加论文
  int insert(Paper paper);
  //根据ID删除论文
  int deleteByPaperId(String paperId);
}
