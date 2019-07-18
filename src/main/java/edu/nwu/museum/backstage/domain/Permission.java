package edu.nwu.museum.backstage.domain;

import java.sql.Timestamp;
import lombok.Data;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;


@Data
public class Permission {
  //权限编号
  private String permId;
  //权限名
  private String permName;
  //权限类型
  private Integer permType;
  //权限资源id
  private Integer permResId;
  //创建时间
  private Timestamp createTime;
  //创建者
  private String creator;
  //更新时间
  private Timestamp updateTime;
  //更新者
  private String updater;
  //删除标识
  private Integer delFlag;
}
