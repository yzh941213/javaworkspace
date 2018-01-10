package com.aishidai.app.config;

import com.aishidai.app.filter.SessionFilter;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.logging.Filter;

@Configurable
public class Config {

    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter( new SessionFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }


}
