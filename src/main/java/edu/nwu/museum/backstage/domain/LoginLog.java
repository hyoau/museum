package edu.nwu.museum.backstage.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

@TableName("t_login_log")
@Data
public class LoginLog {
  // 用户名
  private String userName;
  // 登录时间
  private Date loginTime;
  // 登录地点
  private String location;

  private String ip;
}
