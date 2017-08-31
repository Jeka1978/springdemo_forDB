package com.db.quoters.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;

/**
 * Created by Evegeny on 30/08/2017.
 */
public class BeanDefinitionCorrectnessSentinelBeanFactoryPostProcessor implements BeanFactoryPostProcessor{

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("bean name = " + name);
            AbstractBeanDefinition beanDefinition = (AbstractBeanDefinition) beanFactory.getBeanDefinition(name);
            String destroyMethodName = beanDefinition.getDestroyMethodName();
            if (destroyMethodName != null && beanDefinition.isPrototype()) {
                throw new RuntimeException("ты дибил!!!");
            }
        }
    }
}
