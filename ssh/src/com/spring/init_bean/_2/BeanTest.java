package com.spring.init_bean._2;

import org.junit.Test;

public class BeanTest {


    @Test
    public void test(){

        BeanFactory beanFactory = new AutoWareCableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.spring.init_bean._2.HelloWorldService");

        beanFactory.registerBeanDefinition("helloWorld",beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorld");
        helloWorldService.test();
    }
}
