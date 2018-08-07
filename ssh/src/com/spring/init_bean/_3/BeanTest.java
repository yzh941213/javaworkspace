package com.spring.init_bean._3;

import com.spring.init_bean._2.HelloWorldService;
import org.junit.Test;

public class BeanTest {


    @Test
    public void test(){

        BeanFactory beanFactory = new AutoWareCableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName("com.spring.init_bean._2.HelloWorldService");

        PropertyValue propertyValue = new PropertyValue();
        propertyValue.setName("颜智慧");
        propertyValue.setValue("456");
        beanDefinition.setPropertyValue(propertyValue);
        beanFactory.registerBeanDefinition("helloWorld",beanDefinition);

        HelloWorldService helloWorldService = (HelloWorldService) beanFactory.getBean("helloWorld");
        helloWorldService.test();
    }
}
