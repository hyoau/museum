package edu.nwu.museum.backstage.domain;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Museum {
  //  博物馆id
  private String museum_id;
  //  名字
  private String museum_name;
  //  等级
  private int museum_level;
  //  首页展示权重
  private int show_weight;
  //  地址
  private String museum_address;
  //  官网
  private String museum_index_url;
  //  馆长
  private String curator;
  //  藏品数量
  private int museum_antique_count;
  //  所属部门
  private String museum_department;
  //  门票价格
  private double museum_ticket_price;
  //  竣工时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date museum_complete_time;
  //  组织结构说明
  private String museum_manage_img;
  //  详细介绍
  private String museum_intro;
  //  参观指南
  private String museum_guide;
  //  模板id
  private int template_id;
  //  创建时间
  private Timestamp create_date;
  //  创建人id
  private String creator;
  //  更新时间
  private Timestamp update_date;
  //  更新人id
  private String updater;
  //  删除标识
  private int del_flag;
}
