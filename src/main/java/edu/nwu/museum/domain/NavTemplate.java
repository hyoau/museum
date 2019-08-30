package edu.nwu.museum.domain;

import lombok.Data;

/**
 * 导航模板表
 */
@Data
public class NavTemplate {
  // 博物馆id
  private String museumId;
  // 导航id
  private String navId;
  // 模板id
  private String templateId;
}
