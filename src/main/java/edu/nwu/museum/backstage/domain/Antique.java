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
  private Integer antiqueUsage;
  private Integer antiqueCompletion;
  private Double antiqueLength;
  private Double antiqueWidth;
  private Double antiqueHeight;
  private Double antiqueWeight;
  private Integer antiqueCount;
  private String museumId;
  private String authorId;
  private Integer antiqueLikeCount;
  private Integer antiqueFavouriteCount;
  private Integer antiqueCollectionDepartment;
  private String antiqueSource;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date antiqueCollectionDate;
  private String antiqueRegistrationNum;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date antiqueIdentificationDate;
  private Integer antiqueLevel;
  private String antiqueAppraiser;
  private Integer antiqueProtectionLevel;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date createDate;
  private String creator;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date updateDate;
  private String updater;
  private Integer delFlag;
}
