package edu.nwu.museum.domain;

import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

@Data
public class Group implements Serializable {
  private static final long serialVersionUID = 1L;
  // 用户组id
  private String groupId;
  // 用户组名称
  private String groupName;
  // 用户组信息
  private String groupInfo;
  // 创建日期
  private Date createDate;
  // 创建者id
  private String creator;
  // 更新日期
  private Date updateDate;
  // 更新者id
  private String updater;
  // 删除标识
  private Integer delFlag;
}
