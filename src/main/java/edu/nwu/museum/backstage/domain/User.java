package edu.nwu.museum.backstage.domain;

import edu.nwu.museum.common.converter.TimeConverter;
import edu.nwu.museum.common.domain.RegexpConstant;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wuwenze.poi.annotation.ExcelField;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class User implements Serializable {
  private static final long serialVersionUID = -4852732617765810959L;

  private Long userId;

  private String userName;

  private String password;

  private Date createTime;

  private String status;

  /**
   * shiro-redis v3.1.0 必须要有 getAuthCacheKey()或者 getId()方法
   * # Principal id field name. The field which you can get unique id to identify this principal.
   * # For example, if you use UserInfo as Principal class, the id field maybe userId, userName, email, etc.
   * # Remember to add getter to this id field. For example, getUserId(), getUserName(), getEmail(), etc.
   * # Default value is authCacheKey or id, that means your principal object has a method called "getAuthCacheKey()" or "getId()"
   *
   * @return userId as Principal id field name
   */
  public Long getAuthCacheKey() {
    return userId;
  }
}
