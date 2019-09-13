package edu.nwu.museum.common.aspect;

import edu.nwu.museum.common.annotation.Log;
import edu.nwu.museum.common.utils.HttpContextUtil;
import edu.nwu.museum.common.utils.IPUtil;
import edu.nwu.museum.domain.SysLog;
import edu.nwu.museum.service.SysLogService;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
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
    saveLog(point, time);
    return result;
  }

  private void saveLog(ProceedingJoinPoint joinPoint, long time) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = signature.getMethod();
    SysLog sysLog = new SysLog();
    Log logAnnotation = method.getAnnotation(Log.class);
    if (logAnnotation != null) {
      // Set annotation content
      sysLog.setOperation(logAnnotation.value());
    }
    // Set methods name
    String className = joinPoint.getTarget().getClass().getName();
    String methodName = signature.getName();
    sysLog.setMethod(className + "." + methodName + "()");
    // Set argument value
    Object[] args = joinPoint.getArgs();
    // Set argument name
    LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
    String[] paramNames = u.getParameterNames(method);
    if (args != null && paramNames != null) {
      String params = "";
      for (int i = 0; i < args.length; i++) {
        params += "  " + paramNames[i] + ": " + args[i];
      }
      sysLog.setParams(params);
    }
    // Get request
    HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
    // Set ip address
    sysLog.setIp(IPUtil.getIpAddr(request));
    // Set fake user
    sysLog.setUserId("Meow");
    sysLog.setTime(new Timestamp(time));
    sysLog.setCreateTime(new Timestamp(System.currentTimeMillis()));

    sysLogService.saveSysLog(sysLog);
  }
}
