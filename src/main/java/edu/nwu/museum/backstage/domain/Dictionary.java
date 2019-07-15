package edu.nwu.museum.backstage.domain;

import lombok.Data;

/**
 * 数据字典表
 */
@Data
public class Dictionary {
  // 数据项code
  private Integer dictItemCode;
  // 数据项名称
  private String dictItemName;
  // 数据集code
  private String dictCode;
  // 数据集名称
  private String dictName;
  // 备注
  private String remark;
}
