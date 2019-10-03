package edu.nwu.museum.common.authentication;

import lombok.Data;

@Data
public class Response {
  // http 状态码
  private int code;

  // 返回信息
  private String msg;

  // 返回 Token
  private Object token;

  public Response(int code, String msg, Object token) {
    this.code = code;
    this.msg = msg;
    this.token = token;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public Object getToken() {
    return token;
  }

  public void setToken(Object token) {
    this.token = token;
  }
}
