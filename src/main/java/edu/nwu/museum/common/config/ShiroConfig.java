package edu.nwu.museum.common.config;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
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
  public DefaultWebSecurityManager getManager(ShiroRealm shiroRealm) {
    DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
    // use customized realm
    manager.setRealm(shiroRealm);

    // close session function in shiro
    // http://shiro.apache.org/session-management.html#SessionManagement-StatelessApplications%28Sessionless%29
    DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
    DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
    defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
    subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
    manager.setSubjectDAO(subjectDAO);

    return manager;
  }

  @Bean("shiroFilter")
  public ShiroFilterFactoryBean factory(DefaultWebSecurityManager securityManager) {
    ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

    // add customized filter
    Map<String, Filter> filterMap = new HashMap<>();
    filterMap.put("jwt", new ShiroFilter());
    factoryBean.setFilters(filterMap);

    factoryBean.setSecurityManager(securityManager);
    factoryBean.setUnauthorizedUrl("/401");

    // add customized url rule
    // http://shiro.apache.org/web.html#urls-
    Map<String, String> filterRuleMap = new HashMap<>();

    filterRuleMap.put("/**", "jwt");
    filterRuleMap.put("/401", "anon");

    factoryBean.setFilterChainDefinitionMap(filterRuleMap);
    return factoryBean;
  }

  /**
   * Enable annotation.
   */
  @Bean
  @DependsOn("lifecycleBeanPostProcessor")
  public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
    DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
    // https://zhuanlan.zhihu.com/p/29161098
    defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
    return defaultAdvisorAutoProxyCreator;
  }

  @Bean
  public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
    return new LifecycleBeanPostProcessor();
  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
      DefaultWebSecurityManager securityManager) {
    AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
    advisor.setSecurityManager(securityManager);
    return advisor;
  }
}
