package edu.nwu.museum.backstage.domain;

import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Backup {
  // 连番 主键
  private Integer seqNo;
  // 备份日期
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date backupTime;
  // 备份文件保存地址
  private String backupUrl;
  // 备份版本号
  private String backupVersion;
  // 备份人
  private String userName;
}
