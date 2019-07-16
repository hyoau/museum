package edu.nwu.museum.backstage.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Data
public class Permission {
  //权限编号
  private String permId;
  //权限名
  private String permName;
  //权限类型
  private int permType;
  //权限资源id
  private int permResId;
  //创建时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createTime;
  //创建者
  private String creator;
  //更新时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateTime;
  //更新者
  private String updater;
  //删除标识
  private int delFlag;
}
