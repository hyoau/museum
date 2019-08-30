package edu.nwu.museum.domain;

import java.sql.Date;
import lombok.Data;

/**
 * 资源表
 */
@Data
public class Resource {
  // 资源id
  private String resourceId;
  // 资源类型
  private Integer resourceType;
  // 文件名
  private String resourceName;
  // 资源URL
  private String resourceURL;
  // 创建日期
  private Date createDate;
  // 创建人
  private Integer creator;
  // 删除标识
  private Integer delFlag;
}
