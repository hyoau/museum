package edu.nwu.museum.common.response;

import lombok.Data;

@Data
public class Response {
  // http 状态码
  private int code;

  // 返回信息
  private String msg;

  // 返回 Token
  private Object data;

  public Response(int code, String msg, Object data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }
}
