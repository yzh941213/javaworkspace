package com.spring.init_bean._3;


import java.util.HashMap;

public abstract class AbstractBeanFactory implements BeanFactory {

    private HashMap<String,BeanDefinition>beanDefinitionHashMap = new HashMap<>();


    @Override
    public Object getBean(String name) {
        return beanDefinitionHashMap.get(name).getBean();
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        Object bean = this.doCreateBean(beanDefinition);
        beanDefinition.setBean(bean);
        beanDefinitionHashMap.put(name,beanDefinition);
    }



    protected abstract Object doCreateBean(BeanDefinition beanDefinition);
}
