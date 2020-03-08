package edu.nwu.museum.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class GroupPermission {
    //权限编号
    private String permId;
    //用户组id
    private String groupId;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    //创建者
    private String creator;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    //更新者
    private String updater;
}
