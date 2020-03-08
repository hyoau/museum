package edu.nwu.museum.controller;

import lombok.Data;

@Data
public class UserInfo {
    private String[] roles;
    private String introduction;
    private String avatar;
    private String name;

    UserInfo(String[] roles, String introduction, String avatar, String name) {
        this.roles = roles;
        this.introduction = introduction;
        this.avatar = avatar;
        this.name = name;
    }
}
