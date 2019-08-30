package edu.nwu.museum.dao;

import edu.nwu.museum.domain.Expert;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertMapper {
  //查询所有专家信息
  List<Expert> findAll();
  //根据ID查询专家信息
  Expert findById(String expertId);
  //修改专家信息
  void update(Expert expert);
  //添加专家
  void insert(Expert expert);
  //根据ID删除专家
  int deleteById(String expertId);
}
