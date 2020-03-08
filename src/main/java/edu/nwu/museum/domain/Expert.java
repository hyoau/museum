package edu.nwu.museum.domain;

import lombok.Data;

@Data
public class Expert {
    //专家ID 主键
    private String expertId;
    //专家名字
    private String expertName;
    //头像
    private String expertAvatar;
    //专家介绍
    private String expertIntroduction;
    //博物馆ID
    private String museumId;
}
