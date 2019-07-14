package edu.nwu.museum.backstage.domain;

import java.util.Date;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Antique {
  // 文物id
  private String antiqueId;
  // 文物序列号
  private Integer seqNo;
  // 文物名字
  private String antiqueName;
  // 文物种类
  private Integer antiqueType;
  // 文物朝代
  private Integer antiqueDynasty;
  // 文物地域
  private Integer antiqueArea;
  // 文物材质
  private Integer antiqueTexture;
  // 用途
  private Integer antiqueUsage;
  // 完成度
  private Integer antiqueCompletion;
  // 长度
  private Double antiqueLength;
  // 宽度
  private Double antiqueWidth;
  // 高度
  private Double antiqueHeight;
  // 重量
  private Double antiqueWeight;
  // 数量
  private Integer antiqueCount;
  // 所藏博物馆id
  private String museumId;
  // 作者id
  private String authorId;
  // 点赞数
  private Integer antiqueLikeCount;
  // 收藏数
  private Integer antiqueFavouriteCount;
  // 收藏单位
  private Integer antiqueCollectionDepartment;
  // 来源
  private String antiqueSource;
  // 收藏日期
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date antiqueCollectionDate;
  // 登记号
  private String antiqueRegistrationNum;
  // 鉴定日期
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date antiqueIdentificationDate;
  // 藏品等级
  private Integer antiqueLevel;
  // 鉴定人
  private String antiqueAppraiser;
  // 保护优先等级
  private Integer antiqueProtectionLevel;
  // 创建日期
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createDate;
  // 创建人
  private String creator;
  // 更新日期
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateDate;
  // 更新人
  private String updater;
  // 删除标识
  private Integer delFlag;
}
