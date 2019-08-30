package edu.nwu.museum.domain;

import lombok.Data;

@Data
public class Template {
  //模板ID 主键
  private String templateId;
  //模板名字
  private String templateName;
  //模板类型
  private Integer templateType;
  //模板资源url
  private String templateSourceUrl;
  //模板描述
  private String templateDescription;
  //状态
  private Integer templateStatus;
}
