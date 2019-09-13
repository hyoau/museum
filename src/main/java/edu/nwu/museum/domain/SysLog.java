package edu.nwu.museum.domain;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class SysLog {
  private static final long serialVersionUID = -6309732882044872298L;

  private Integer id;
  private String userId;
  private String operation;
  private Timestamp time;
  private String method;
  private String params;
  private String ip;
  private Timestamp createTime;
}
