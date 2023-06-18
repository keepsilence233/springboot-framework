package org.example.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * {@link BeanFactoryPostProcessor} 是 Spring 中的一个扩展接口。它允许在 Spring 容器实例化 Bean 之前，修改 Bean 的定义属性以及添加新的 Bean 定义
 * 在 Spring 应用上下文初始化后，会回调所有实现了 BeanFactoryPostProcessor 的 Bean ，且在所有 Bean 实例化之前，调用其 postProcessBeanFactory 方法
 * 在该方法中，可以修改 Bean 工厂的定义，添加新的 Bean 定义，或者删除不需要的 Bean 定义等
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public CustomBeanFactoryPostProcessor() {
        System.out.println("[CustomBeanFactoryPostProcessor] 构造器");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("执行 [CustomBeanFactoryPostProcessor#postProcessBeanFactory] 方法 获取user bean定义后添加属性mobile=110");

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("user");
        beanDefinition.getPropertyValues().addPropertyValue("mobile", "110");

    }
}
