package edu.nwu.museum.backstage.domain;

import java.sql.Date;
import lombok.Data;

@Data
public class User {
  // 用户id
  private String userId;
  // 用户名
  private String userName;
  // 密码
  private String password;
  // 电话号码
  private String userTel;
  // 邮箱
  private String email;
  // 部门
  private Long deptId;
  // 用户头像
  private String userAvatar;
  // 用户性别
  private Integer userSex;
  // 用户状态
  private Integer userStatus;
  // 地址
  private String address;
  // 出生日期
  private Date birthday;
  // 所属博物馆id
  private String museumId;
  // 真实姓名
  private String realName;
  // 创建日期
  private Date createDate;
  // 创建者id
  private String creator;
  // 更新日期
  private Date updateDate;
  // 更新者id
  private String updater;
}
