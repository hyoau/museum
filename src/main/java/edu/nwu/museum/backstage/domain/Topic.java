package edu.nwu.museum.backstage.domain;

import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Topic {
  // 博物馆id
  private String museumId;
  // 专题id
  private String topicId;
  // 专题标题
  private String topicName;
  // 分类
  private Integer topicType;
  // 首页展示权重
  private Integer showWeight;
  // 图片url
  private String topicImageUrl;
  // 专题描述
  private String topicDescription;
  // 创建日期
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createDate;
  // 创建人
  private String creator;
  // 更新日期
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateDate;
  // 更新人id
  private String updater;
  // 删除标识
  private Integer delFlag;
}
