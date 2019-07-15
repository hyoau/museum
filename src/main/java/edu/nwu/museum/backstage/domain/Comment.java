package edu.nwu.museum.backstage.domain;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Comment {
    //文物序列号
    private int antique_seq_no;
    //评论序列号
    private int comment_seq_no;
    //内容
    private String commont_content;
    //评论者id
    private String user_id;
    //时间
    private Timestamp comment_time;
    //点赞数
    private int like_count;
    //被评论者id
    private String commented_user_id;
}
