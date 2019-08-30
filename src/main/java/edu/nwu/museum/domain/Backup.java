package edu.nwu.museum.domain;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class Backup {
  // 连番 主键
  private Integer seqNo;
  // 备份日期
  private Timestamp backupTime;
  // 备份文件保存地址
  private String backupUrl;
  // 备份版本号
  private String backupVersion;
  // 备份人
  private String userName;
}
