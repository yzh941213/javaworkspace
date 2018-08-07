package com.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class SimpleBeanFactory {


    public static void main(String[] args) {

        ClassPathResource resource = new ClassPathResource("");
        BeanFactory beanFactory = new XmlBeanFactory(resource);


        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.createReaderContext(resource);


    }
}
