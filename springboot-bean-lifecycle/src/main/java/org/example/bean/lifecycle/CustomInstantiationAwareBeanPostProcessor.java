package org.example.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

/**
 * InstantiationAwareBeanPostProcessor是BeanPostProcessor的扩展接口之一，用于在bean实例化前和实例化后提供更灵活的控制。
 */
//@Component
public class CustomInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {


    /**
     * 这个方法在bean初始化之前调用，可以进行额外的处理，比如动态代理。
     *
     * @param bean     the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("[CustomInstantiationAwareBeanPostProcessor] before initialization " + beanName);
        return bean;
    }


    /**
     * 仅在bean实例化前被调用，允许返回一个新的bean实例，或者返回null来使用默认方式实例化bean。
     *
     * @param beanClass the class of the bean to be instantiated
     * @param beanName  the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        System.out.println("[CustomInstantiationAwareBeanPostProcessor] before instantiation " + beanName);
        return null;
    }

    /**
     * 仅在bean初始化后被调用，允许对bean进行额外的处理。
     *
     * @param bean     the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("[CustomInstantiationAwareBeanPostProcessor] after initialization " + beanName);
        return bean;
    }

    /**
     * 这个方法在bean实例化后调用，允许对bean的属性进行修改。
     *
     * @param bean     the bean instance created, with properties not having been set yet
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        System.out.println("[CustomInstantiationAwareBeanPostProcessor] after instantiation " + beanName);
        return true;
    }

    /**
     * 这个方法在bean实例化后调用，允许对bean的属性进行修改或替换。
     *
     * @param pvs      the property values that the factory is about to apply (never {@code null})
     * @param pds      the relevant property descriptors for the target bean (with ignored
     *                 dependency types - which the factory handles specifically - already filtered out)
     * @param bean     the bean instance created, but whose properties have not yet been set
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
//        System.out.println("[CustomInstantiationAwareBeanPostProcessor] postProcessPropertyValues " + beanName);
        return pvs;
    }


}
