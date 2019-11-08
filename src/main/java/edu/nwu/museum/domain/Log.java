package edu.nwu.museum.domain;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class Log {
  private Integer logSeqNo;

  private String userId;

  private String loginIp;

  private Integer logActionType;

  private String logAction;

  private Timestamp logActionTime;

  private Timestamp loginTime;

  private Timestamp logoutTime;
}
