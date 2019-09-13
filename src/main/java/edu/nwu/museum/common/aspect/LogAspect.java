package edu.nwu.museum.common.aspect;

import edu.nwu.museum.common.authentication.JWTUtil;
import edu.nwu.museum.common.properties.MuseumProperties;
import edu.nwu.museum.common.utils.HttpContextUtil;
import edu.nwu.museum.common.utils.IPUtil;
import edu.nwu.museum.domain.SysLog;
import edu.nwu.museum.service.SysLogService;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
  @Autowired
  private SysLogService sysLogService;

  @Pointcut("@annotation(edu.nwu.museum.common.annotation.Log)")
  public void pointcut() {}

  @Around("pointcut()")
  public Object around(ProceedingJoinPoint point) {
    Object result = null;
    long beginTime = System.currentTimeMillis();
    try {
      result = point.proceed();
    } catch (Throwable e) {
      e.printStackTrace();
    }
    long time = System.currentTimeMillis() - beginTime;
    // saveLog(point, time);
    return result;
  }
}
