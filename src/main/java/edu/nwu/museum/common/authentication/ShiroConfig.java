package edu.nwu.museum.common.authentication;

import java.util.LinkedHashMap;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Configuration
public class ShiroConfig {
  @Bean
  public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    // 设置securityManager
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    // 登录的url
    shiroFilterFactoryBean.setLoginUrl("/login");
    // 登录成功后跳转的url
    shiroFilterFactoryBean.setSuccessUrl("/index");
    // 未授权url
    shiroFilterFactoryBean.setUnauthorizedUrl("/403");

    LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

    // 定义filterChain，静态资源不拦截
    filterChainDefinitionMap.put("/css/**", "anon");
    filterChainDefinitionMap.put("/js/**", "anon");
    filterChainDefinitionMap.put("/fonts/**", "anon");
    filterChainDefinitionMap.put("/img/**", "anon");
    // 配置退出过滤器，其中具体的退出代码Shiro已经替我们实现了
    filterChainDefinitionMap.put("/logout", "logout");
    filterChainDefinitionMap.put("/", "anon");
    // 除上以外所有url都必须认证通过才可以访问，未通过认证自动访问LoginUrl
    // user指的是用户认证通过或者配置了Remember Me记住用户登录状态后可访问
    filterChainDefinitionMap.put("/**", "user");

    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    return shiroFilterFactoryBean;
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
    authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
    return authorizationAttributeSourceAdvisor;
  }

  @Bean
  public SecurityManager securityManager(){
    // 配置SecurityManager，并注入shiroRealm
    DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
    securityManager.setRealm(shiroRealm());
    securityManager.setRememberMeManager(rememberMeManager());
    return securityManager;
  }

  @Bean
  public ShiroRealm shiroRealm(){
    // 配置Realm，需自己实现
    ShiroRealm shiroRealm = new ShiroRealm();
    return shiroRealm;
  }

  /**
   * cookie对象
   * @return
   */
  public SimpleCookie rememberMeCookie() {
    // 设置cookie名称，对应login.html页面的<input type="checkbox" name="rememberMe"/>
    SimpleCookie cookie = new SimpleCookie("rememberMe");
    // 设置cookie的过期时间，单位为秒，这里为一天
    cookie.setMaxAge(86400);
    return cookie;
  }

  /**
   * cookie管理对象
   * @return
   */
  public CookieRememberMeManager rememberMeManager() {
    CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
    cookieRememberMeManager.setCookie(rememberMeCookie());
    // rememberMe cookie加密的密钥
    cookieRememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
    return cookieRememberMeManager;
  }

  /**
   * 如果用户没有权限，自动跳转回403，解决AuthorizationException
   */
  @ControllerAdvice
  @Order(value = Ordered.HIGHEST_PRECEDENCE)
  public class GlobalExceptionHandler {
    @ExceptionHandler(value = AuthorizationException.class)
    public String handleAuthorizationException() {
      return "403";
    }
  }
}
