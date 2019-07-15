package edu.nwu.museum.backstage.domain;

import lombok.Data;

@Data
public class PermResource {
  //权限资源id
  private String perm_res_id;
  //权限资源访问名
  private String perm_res_name;
  //访问资源路由
  private String perm_url;
}
