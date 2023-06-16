package org.example.bean.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class User implements InitializingBean, DisposableBean {


    public User() {
        System.out.println("调用Bean的函数(constructor)");
    }

    public User(String name) {
        this.name = name;
        System.out.println("调用Bean的构造函数(constructor)");
    }

    /* -- --- - -- - -- -- Field -- - -- - - - -- -- - -- */

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("调用Bean的函数(setName)");
    }

    /* -- --- - -- - -- -- Field -- - -- - - - -- -- - -- */

    /**
     * 初始化完成之前调用
     */
    @PostConstruct
    public void init() {
        System.out.println("调用Bean的函数(postConstruct)");
    }

    //MainConfig中@Bean 的initMethod
    public void initMethod() {
        System.out.println("调用Bean的函数(initMethod)");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用Bean的函数(afterPropertiesSet)");
    }

    /**
     * 销毁完成之前调用
     */
    @PreDestroy
    public void preDestroy() {
        System.out.println("调用Bean的函数(preDestroy)");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("调用Bean的函数(destroy)");
    }

    //MainConfig中@Bean 的destroyMethod
    public void destroyMethod() {
        System.out.println("调用Bean的函数(destroyMethod)");
    }
}
