package edu.nwu.museum.domain;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Museum {
  //  博物馆id
  private String museumId;
  //  名字
  private String museumName;
  //  等级
  private Integer museumLevel;
  //  首页展示权重
  private Integer showWeight;
  //  地址
  private String museumAddress;
  //  官网
  private String museumIndexUrl;
  //  馆长
  private String museumCurator;
  //  藏品数量
  private Integer museumAntiqueCount;
  //  所属部门
  private String museumDepartment;
  //  门票价格
  private Double museumTicketPrice;
  //  竣工时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date museumCompletedTime;
  //  组织结构说明
  private String museumManageImg;
  //  详细介绍
  private String museumIntro;
  //  参观指南
  private String museumGuide;
  //  模板id
  private Integer templateId;
  //  创建时间
  private Timestamp createDate;
  //  创建人id
  private String creator;
  //  更新时间
  private Timestamp updateDate;
  //  更新人id
  private String updater;
  //  删除标识
  private Integer delFlag;
}
