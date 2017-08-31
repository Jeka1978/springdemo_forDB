package com.db.quoters.bpp;

import com.db.quoters.DeprecatedClass;
import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

/**
 * Created by Evegeny on 31/08/2017.
 */
public class DeprecatedClassReplacerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> beanClass = ClassUtils.resolveClassName(beanClassName, ClassLoader.getSystemClassLoader());
            DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
            if (annotation != null) {
                Class newClass = annotation.value();
                beanDefinition.setBeanClassName(newClass.getName());
            }
        }
    }
}








