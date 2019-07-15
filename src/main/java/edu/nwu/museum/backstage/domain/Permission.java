package edu.nwu.museum.backstage.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Data
public class Permission {
  //权限编号
  private String perm_id;
  //权限名
  private String prem_name;
  //权限类型
  private int prem_type;
  //权限资源id
  private int perm_res_id;
  //创建时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date create_time;
  //创建者
  private String creator;
  //更新时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date update_time;
  //更新者
  private String updater;
  //删除标识
  private int del_flag;
}
