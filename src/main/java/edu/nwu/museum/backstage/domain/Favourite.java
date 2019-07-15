package edu.nwu.museum.backstage.domain;

import lombok.Data;

@Data
public class Favourite {
  // 用户id 主键
  private String userId;
  // 收藏序列号 主键
  private Integer seqNo;
  // 文物id
  private String antiqueId;
  // 博物馆id
  private String museumId;
  // 专题id
  private String topicId;
}
