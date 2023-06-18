package org.example.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class User implements InitializingBean, DisposableBean, ApplicationRunner, CommandLineRunner, BeanNameAware, ApplicationContextAware {


    public User() {
        System.out.println("[user bean] 无参构造");
    }

    public User(String name) {
        this.name = name;
        System.out.println("[user bean] 带参构造");
    }

    /* -- --- - -- - -- -- Field -- - -- - - - -- -- - -- */

    private String name;

    private String mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("[user bean 属性注入] name:" + name);
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        System.out.println("[user bean 属性注入] mobile:" + mobile);
        this.mobile = mobile;
    }
    /* -- --- - -- - -- -- Field -- - -- - - - -- -- - -- */

    /**
     * 初始化完成之前调用
     */
    @PostConstruct
    public void init() {
        System.out.println("[user bean] @PostConstruct");
    }

    //MainConfig中@Bean 的initMethod
    public void initMethod() {
        System.out.println("[init-method]调用<bean>的init-method属性指定的初始化方法");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("接口InitializingBean#afterPropertiesSet");
    }

    /**
     * 销毁完成之前调用
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("[user bean] @PreDestroy");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("接口DisposableBean#destroy");
    }

    //MainConfig中@Bean 的destroyMethod
    public void destroyMethod() {
        System.out.println("[destroy-method]调用<bean>destroy-method属性指定的销毁方法");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("接口ApplicationRunner#run");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("接口CommandLineRunner#run");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("接口BeanNameAware#setBeanName");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("接口ApplicationContextAware#setApplicationContext");
    }
}
