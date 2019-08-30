package edu.nwu.museum.domain;

import lombok.Data;
import java.util.Date;

@Data
public class LoginLog {
  // 用户名
  private String userName;
  // 登录时间
  private Date loginTime;
  // 登录地点
  private String location;
  // IP
  private String ip;
}
