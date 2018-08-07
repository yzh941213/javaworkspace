package com.spring.init_bean._2;

public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name,BeanDefinition beanDefinition);
}
