package edu.nwu.museum.backstage.dao;

import edu.nwu.museum.backstage.domain.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface DeptMapper extends BaseMapper<Dept> {
  /**
   * 递归删除部门
   *
   * @param deptId deptId
   */
  void deleteDepts(String deptId);
}
