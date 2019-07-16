package edu.nwu.museum.backstage.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {
  //文物序列号
  private int antiqueSeqNo;
  //评论序列号
  private int commentSeqNo;
  //内容
  private String commentContent;
  //评论者id
  private String userId;
  //时间
  private Timestamp commentTime;
  //点赞数
  private int likeCount;
  //被评论者id
  private String commentedUserId;
}
