package edu.nwu.museum.domain;

import lombok.Data;

@Data
public class PermResource {
  //权限资源id
  private String permResId;
  //权限资源访问名
  private String permResName;
  //访问资源路由
  private String permUrl;
}
