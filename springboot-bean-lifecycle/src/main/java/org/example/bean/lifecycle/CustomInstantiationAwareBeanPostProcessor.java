package org.example.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.stereotype.Component;

import java.beans.PropertyDescriptor;
import java.util.Objects;

/**
 * {@link InstantiationAwareBeanPostProcessorAdapter} 是 {@link org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor} 的接口适配类
 * 用于在Spring容器实例化 Bean 之前或之后处理，它可以在 Bean 实例化的任意阶段介入 Spring 容器创建 Bean 的过程
 */
@Component
public class CustomInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public CustomInstantiationAwareBeanPostProcessor() {
        System.out.println("[CustomInstantiationAwareBeanPostProcessor] 构造器");
    }


    /**
     * 实例化Bean之前调用
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (Objects.equals(beanName, "user")) {
            System.out.println("[CustomInstantiationAwareBeanPostProcessor] before instantiation " + beanName);
        }
        return null;
    }

    /**
     * 实例化Bean之后调用
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "user")) {
            System.out.println("[CustomInstantiationAwareBeanPostProcessor] after initialization " + beanName);
        }
        return bean;
    }

    /**
     * 设置Bean的某个属性时调用
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "user")) {
            System.out.println("[CustomInstantiationAwareBeanPostProcessor] postProcessPropertyValues beanName: " + beanName + "  pvs: " + pvs);
        }
        return pvs;
    }


}
