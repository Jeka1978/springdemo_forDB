package com.db.quoters.bpp;

import com.db.quoters.Transaction;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Evegeny on 31/08/2017.
 */

@Component
public class TransactionAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private TransactionManager transactionManager;

    private Map<String, Class> map = new ConcurrentHashMap<>();


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Transaction.class)) {
            map.put(beanName, bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = map.get(beanName);
        if (beanClass!=null) {
            return Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    transactionManager.open();
                    Object retVal = null;
                    try {
                        retVal = method.invoke(bean);
                    } catch (Exception e) {
                        transactionManager.rollback();
                        throw new RuntimeException(e);
                    } finally {
                        transactionManager.close();
                        return retVal;
                    }

                }
            });
        }
        return bean;
    }
}


















