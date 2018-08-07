package com.spring.init_bean._1;

import java.util.HashMap;

public class BeanFactory {

    private HashMap<String,BeanDefinition>beanDefinition = new HashMap<>();


    public Object getBean(String name,Class<?>_class){
        return beanDefinition.get(name).getBean();
    }


    public void registerBeanDefinition(String name,BeanDefinition bean){
        beanDefinition.put(name,bean);
    }
}
