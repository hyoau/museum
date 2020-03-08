package edu.nwu.museum.domain;

import lombok.Data;

@Data
public class Request {
    // http 状态码
    private int code;

    // 返回信息
    private String msg;

    // 返回 Token
    private Object data;

    public Request(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
