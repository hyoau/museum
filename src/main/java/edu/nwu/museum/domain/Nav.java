package edu.nwu.museum.domain;

import lombok.Data;

/**
 * 导航表
 */
@Data
public class Nav {
  // 导航id 主键
  private Integer navId;
  // 导航名称
  private String navName;
  // 下级导航id
  private Integer subNavId;
  // 下级导航名称
  private String subNavName;
  // 所属博物馆id
  private String museumId;
}
