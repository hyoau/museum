package edu.nwu.museum.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTUtil {
  // set expire time is 5 min.
  private static final long EXPIRE_TIME = 5*60*1000;

  // verify whether token is correct
  public static boolean verify(String token, String userId, String secret) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      JWTVerifier verifier = JWT.require(algorithm)
          .withClaim("userId", userId)
          .build();
      verifier.verify(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  // get user info without getting secret(password)
  public static String getUserId(String token) {
    try {
      DecodedJWT jwt = JWT.decode(token);
      return jwt.getClaim("userId").asString();
    } catch (JWTDecodeException e) {
      return null;
    }
  }

  // generate token and it will expire after 5 min
  public static String sign(String userId, String secret) {
    try {
      Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
      Algorithm algorithm = Algorithm.HMAC256(secret);
      // attach user info
      return JWT.create()
          .withClaim("userId", userId)
          .withExpiresAt(date)
          .sign(algorithm);
    } catch (Exception e) {
      return null;
    }
  }
}

