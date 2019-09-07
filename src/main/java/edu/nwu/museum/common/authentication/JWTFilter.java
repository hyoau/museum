package edu.nwu.museum.common.authentication;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
public class JWTFilter extends BasicHttpAuthenticationFilter {
  /**
   * 判断用户是否想要登入，检测 header 里面是否包含 Authorization 字段即可。
   */
  @Override
  protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
    HttpServletRequest req = (HttpServletRequest) request;
    String authorization = req.getHeader("Authorization");
    return authorization != null;
  }

  @Override
  protected boolean executeLogin(ServletRequest request, ServletResponse response){
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    String authorization = httpServletRequest.getHeader("Authorization");

    JWTToken token = new JWTToken(authorization);
    // 提交给 realm 进行登入，如果错误他会抛出异常并被捕获
    getSubject(request, response).login(token);
    // 如果没有抛出异常则代表登入成功，返回 true
    return true;
  }

  /**
   * 最终返回的都是 true，即允许访问，如果在这里返回了false，请求会被直接拦截，用户看不到任何东西。
   * @param request
   * @param response
   * @param mappedValue
   * @return
   */
  @Override
  protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
    if (isLoginAttempt(request, response)) {
      try {
        executeLogin(request, response);
      } catch (Exception e) {
        response401(request, response);
      }
    }
    return true;
  }


  /**
   * 对跨域提供支持
   */
  @Override
  protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
    httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
    httpServletResponse.setHeader("Access-Control-Allow-Headers", httpServletRequest.getHeader("Access-Control-Request-Headers"));
    // 跨域时会首先发送一个 option 请求，这里我们给 option 请求直接返回正常状态
    if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
      httpServletResponse.setStatus(HttpStatus.OK.value());
      return false;
    }
    return super.preHandle(request, response);
  }

  /**
   * 将非法请求跳转到 /401
   */
  private void response401(ServletRequest req, ServletResponse resp) {
    try {
      HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
      httpServletResponse.sendRedirect("/401");
    } catch (IOException e) {
      log.error(e.getMessage());
    }
  }
}
