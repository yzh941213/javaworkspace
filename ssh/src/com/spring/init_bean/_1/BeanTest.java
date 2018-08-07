package com.spring.init_bean._1;


public class BeanTest {

    public static void main(String[] args) {

        BeanFactory beanFactory = new BeanFactory();
        HelloWorldService helloWorldService = new HelloWorldService();
        BeanDefinition beanDefinition = new BeanDefinition(helloWorldService);
        beanFactory.registerBeanDefinition("hello",beanDefinition);

        HelloWorldService getBeanService = (HelloWorldService) beanFactory.getBean("hello",HelloWorldService.class);

        getBeanService.test();

    }
}
