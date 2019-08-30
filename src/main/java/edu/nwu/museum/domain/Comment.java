package edu.nwu.museum.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {
  //文物序列号
  private Integer antiqueSeqNo;
  //评论序列号
  private Integer commentSeqNo;
  //内容
  private String commentContent;
  //评论者id
  private String userId;
  //时间
  private Timestamp commentTime;
  //点赞数
  private Integer likeCount;
  //被评论者id
  private String commentedUserId;
}
