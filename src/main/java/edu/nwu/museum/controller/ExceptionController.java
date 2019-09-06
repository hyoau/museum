package edu.nwu.museum.controller;

import edu.nwu.museum.common.authentication.Response;
import edu.nwu.museum.common.exception.UnauthorizedException;
import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
  // 捕捉 Shiro 的异常
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(ShiroException.class)
  public Response handle401(ShiroException e) {
    return new Response(401, e.getMessage(), null);
  }

  // 捕捉 UnauthorizedException
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(UnauthorizedException.class)
  public Response handle401() {
    return new Response(401, "Unauthorized", null);
  }

  // 捕捉其他所有异常
  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Response globalException(HttpServletRequest request, Throwable ex) {
    return new Response(getStatus(request).value(), ex.getMessage(), null);
  }

  private HttpStatus getStatus(HttpServletRequest request) {
    Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
    if (statusCode == null) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    }
    return HttpStatus.valueOf(statusCode);
  }
}
