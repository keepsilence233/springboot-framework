package org.example.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;

/**
 * SmartInstantiationAwareBeanPostProcessor是BeanPostProcessor的一个扩展接口，用于在实例化bean之前和实例化bean之后提供更细粒度的控制。
 */
//@Component
public class CustomSmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {
    /**
     * 该方法用于在应用程序生成类实例之前预测确切的bean类型。
     *
     * @param beanClass the raw class of the bean
     * @param beanName  the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
//        System.out.println("[SmartInstantiationAwareBeanPostProcessorPoint] predictBeanType " + beanName);
        return beanClass;
    }

    /**
     * 该方法用于选择正确的构造函数，以便Spring Boot能够正确创建bean。
     *
     * @param beanClass the raw class of the bean (never {@code null})
     * @param beanName  the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
//        System.out.println("[SmartInstantiationAwareBeanPostProcessorPoint] determineCandidateConstructors " + beanName);
        return null;
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
//        System.out.println("[SmartInstantiationAwareBeanPostProcessorPoint] getEarlyBeanReference " + beanName);
        return bean;
    }
}
