package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Expert;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpertMapper {
  //查询所有专家信息
  List<Expert> findAll();
  //根据ID查询专家信息
  Expert findByExpertId(String expertId);
  //修改专家信息
  int update(Expert expert);
  //添加专家
  int insert(Expert expert);
  //根据ID删除专家
  int deleteByExpertId(String expertId);
}
