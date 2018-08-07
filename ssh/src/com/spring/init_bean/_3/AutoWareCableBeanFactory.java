package com.spring.init_bean._3;

import java.lang.reflect.Field;

public class AutoWareCableBeanFactory extends AbstractBeanFactory {

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


    protected void applyPropertyValues(Object bean,BeanDefinition beanDefinition){
        try {
           Field field = bean.getClass().getDeclaredField(beanDefinition.getPropertyValue().getName());
           field.setAccessible(true);
           field.set(bean,beanDefinition);
        }catch (NoSuchFieldException ex){
            ex.printStackTrace();
        }catch (IllegalAccessException ex){
            ex.printStackTrace();
        }

    }
}
