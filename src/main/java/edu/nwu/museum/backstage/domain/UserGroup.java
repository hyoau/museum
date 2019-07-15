package edu.nwu.museum.backstage.domain;

import java.sql.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class UserGroup {
  // 用户组id
  private String groupId;
  // 用户组名称
  private String groupName;
  // 用户id
  private String userId;
  // 用户真实姓名
  private String realName;
  // 创建日期
  private Date createDate;
  // 创建者
  private String creator;
  // 更新日期
  private Date updateDate;
  // 更新者
  private String updater;
}
