package edu.nwu.museum.domain;


import java.sql.Date;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Paper {
    //论文ID 主键
    private String paperId;
    //论文标题
    private String paperTitle;
    //论文作者
    private String paperAuthor;
    //关键词
    private String keyWord;
    //期刊
    private String paperPeriodical;
    //发表时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creatTime;
    //论文内容
    private String paperText;
    //论文图片
    private String paperImage;
    //博物馆ID
    private String museumId;
}
