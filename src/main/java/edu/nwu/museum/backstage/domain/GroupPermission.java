package edu.nwu.museum.backstage.domain;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
public class GroupPermission {
    //权限编号
    private String perm_id;
    //用户组id
    private String group_id;
    //创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date create_time;
    //创建者
    private String creator;
    //更新时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date update_time;
    //更新者
    private String updater;
}
