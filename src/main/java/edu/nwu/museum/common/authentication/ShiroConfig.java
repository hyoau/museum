package edu.nwu.museum.common.authentication;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroConfig {
  @Bean("securityManager")
  public DefaultWebSecurityManager getManager() {
    DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
    // set customized realm
    manager.setRealm(shiroRealm());

    // close session in Shiro
    // http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
    DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
    DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
    defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
    subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
    manager.setSubjectDAO(subjectDAO);

    return manager;
  }

  @Bean
  public ShiroRealm shiroRealm() {
    return new ShiroRealm();
  }

  @Bean("shiroFilter")
  public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
    ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

    // set customized filter and set name 'jwt'
    Map<String, Filter> filterMap = new HashMap<>();
    filterMap.put("jwt", new JWTFilter());
    factoryBean.setFilters(filterMap);

    factoryBean.setSecurityManager(securityManager);
    factoryBean.setUnauthorizedUrl("/401");

    // 自定义url规则
    Map<String, String> filterRuleMap = new HashMap<>();
    // 所有请求通过我们自己的JWT Filter
    filterRuleMap.put("/**", "jwt");
    // 访问401和404页面不通过我们的Filter
    filterRuleMap.put("/401", "anon");
    factoryBean.setFilterChainDefinitionMap(filterRuleMap);
    return factoryBean;
  }

  /**
   * Boilerplate code.
   */
  @Bean
  @DependsOn("lifecycleBeanPostProcessor")
  public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
    // force cglib to prevent duplicate agents and problems that may cause agent errors
    // https://zhuanlan.zhihu.com/p/29161098
    defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
    return defaultAdvisorAutoProxyCreator;
  }

  @Bean
  public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
    return new LifecycleBeanPostProcessor();
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
    advisor.setSecurityManager(securityManager);
    return advisor;
  }
}
