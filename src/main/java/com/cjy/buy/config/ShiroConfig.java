package com.cjy.buy.config;

import com.cjy.buy.manager.RedisCacheManager;
import com.cjy.buy.manager.RedisSessionManager;
import com.cjy.buy.untils.MyRealm;
import com.cjy.buy.untils.RedisSessionDao;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;

/**
 * Created by Administrator on 2019/1/25.
 */
@Configuration
public class ShiroConfig {
    /**
     * 密码校验规则HashedCredentialsMatcher
     * 这个类是为了对密码进行编码的 ,
     * 防止密码在数据库里明码保存 , 当然在登陆认证的时候 ,
     * 这个类也负责对form里输入的密码进行编码
     * 处理认证匹配处理器：如果自定义需要实现继承HashedCredentialsMatcher
     */
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }


    @Bean("authRealm")
    @DependsOn("lifecycleBeanPostProcessor")//可选
    public MyRealm authRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {
        MyRealm authRealm = new MyRealm();
        //这里控制是否需要缓存 true
        authRealm.setAuthorizationCachingEnabled(true);
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }

    @Bean
    public RedisSessionDao sessionDao(){
        RedisSessionDao sessionDao=new RedisSessionDao();
        return sessionDao;
    }

    @Bean
    public RedisSessionManager sessionManager(){
        RedisSessionManager sessionManager=new RedisSessionManager();
        sessionManager.setSessionDAO(sessionDao());
        return sessionManager;
    }


    @Bean
    public SimpleCookie cookie(){
        SimpleCookie simpleCookie=new SimpleCookie();
        simpleCookie.setName("rememberMe");
        //记着我的cookie的持续时间
        simpleCookie.setMaxAge(3600);
        return simpleCookie;
    }

    @Bean
    public CookieRememberMeManager cookieRememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager=new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(cookie());
        return cookieRememberMeManager;
    }

    @Bean("redisCacheManager")
    public RedisCacheManager redisCacheManager(){
        RedisCacheManager redisCacheManager=new RedisCacheManager();
        return redisCacheManager;
    }
    /**
     * 定义安全管理器securityManager,注入自定义的realm
     * @param authRealm
     * @return
     */
    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") MyRealm authRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        manager.setSessionManager(sessionManager());
        manager.setCacheManager(redisCacheManager());
        manager.setRememberMeManager(cookieRememberMeManager());
        return manager;
    }

//    @Bean("advisor")
//    public AuthorizationAttributeSourceAdvisor advisor(@Qualifier("authRealm") MyRealm authRealm) {
//        AuthorizationAttributeSourceAdvisor advisor=new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(securityManager(authRealm));
//        return advisor;
//    }


    /**
     * 定义shiroFilter过滤器并注入securityManager
     * @param manager
     * @return
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager manager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置securityManager
        bean.setSecurityManager(manager);
        //设置登录页面
        //可以写路由也可以写jsp页面的访问路径
        bean.setLoginUrl("/html");
        //设置登录成功跳转的页面
        bean.setSuccessUrl("index");
        //设置未授权跳转的页面
        bean.setUnauthorizedUrl("getopt");
        //定义过滤器
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        filterChainDefinitionMap.put("index", "authc");
        filterChainDefinitionMap.put("html", "anon");
        filterChainDefinitionMap.put("/user/login", "anon");
//        filterChainDefinitionMap.put("/admin", "roles[admin]");
//        filterChainDefinitionMap.put("/edit", "perms[delete]");
//        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/statics/**", "anon");
        //需要登录访问的资源 , 一般将/**放在最下边
        filterChainDefinitionMap.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

    /**
     * Spring的一个bean , 由Advisor决定对哪些类的方法进行AOP代理 .
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    /**
     * 配置shiro跟spring的关联
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
     * lifecycleBeanPostProcessor是负责生命周期的 , 初始化和销毁的类
     * (可选)
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}

