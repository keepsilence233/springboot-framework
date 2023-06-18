package org.example.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * {@link BeanPostProcessor} 是 Spring 中的一个扩展接口，用于在对 Bean 进行初始化前后进行处理
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    public CustomBeanPostProcessor() {
        System.out.println("[CustomBeanPostProcessor] 构造器");
    }

    /**
     * bean 初始化之前处理器
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "user")) {
            System.out.println("[CustomBeanPostProcessor] before initialization " + beanName);
        }
        return bean;
    }


    /**
     * bean 初始化之后处理器
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "user")) {
            System.out.println("[CustomBeanPostProcessor] after initialization " + beanName);
        }
        return bean;
    }
}
