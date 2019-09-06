package edu.nwu.museum.common.authentication;

import lombok.Data;
import org.apache.shiro.authc.AuthenticationToken;

@Data
public class JWTToken implements AuthenticationToken {
  private static final long serialVersionUID = 1282057025599826155L;

  private String token;

  private String exipreAt;

  public JWTToken(String token) {
    this.token = token;
  }

  public JWTToken(String token, String expireAt) {
    this.token = token;
    this.exipreAt = expireAt;
  }

  @Override
  public Object getPrincipal() {
    return token;
  }

  @Override
  public Object getCredentials() {
    return token;
  }
}
