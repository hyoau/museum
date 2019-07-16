package edu.nwu.museum.backstage.domain;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class Log {
  //日志序列号
  private int logSeqNo;
  //用户id
  private String userId;
  //用户名
  private String userName;
  //登陆ip地址
  private String loginIp;
  //操作类型
  private int logActionType;
  //操作内容
  private String logAction;
  //操作时间
  private Timestamp logActionTime;
}
