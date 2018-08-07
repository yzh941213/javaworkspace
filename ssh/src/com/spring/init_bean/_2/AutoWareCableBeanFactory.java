package com.spring.init_bean._2;

public class AutoWareCableBeanFactory extends AbstrBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        }catch (InstantiationException ex){
            ex.printStackTrace();
        }catch (IllegalAccessException ex){
            ex.printStackTrace();
        }
        return bean;
    }
}
