package edu.nwu.museum.backstage.domain;

import java.sql.Date;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class News {
  //资讯ID
  private String newsId;
  //资讯标题
  private String newsTitle;
  //资讯类型
  private Integer newsType;
  //主持人
  private String newsSpeaker;
  //活动开始时间
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private DateTime newsTime;
  //博物馆ID
  private String museumId;
  //图片
  private String newsImage;
  //咨询内容
  private String newsText;
  //发布时间
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createTime;
  //发布者ID
  private String creator;
}
