package edu.nwu.museum.backstage.domain;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class Log {
  //日志序列号
  private int log_seq_no;
  //用户id
  private String user_id;
  //用户名
  private String user_name;
  //登陆ip地址
  private String login_ip;
  //操作类型
  private int log_action_type;
  //操作内容
  private String log_action;
  //操作时间
  private Timestamp log_action_time;
}
