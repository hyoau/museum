package edu.nwu.museum.backstage.domain;

import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Group {
  // 用户组id
  private String groupId;
  // 用户组名称
  private String groupName;
  // 用户组信息
  private String groupInfo;
  // 创建日期
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createDate;
  // 创建者id
  private String creator;
  // 更新日期
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateDate;
  // 更新者id
  private String updater;
  // 删除标识
  private Integer delFlag;
}
