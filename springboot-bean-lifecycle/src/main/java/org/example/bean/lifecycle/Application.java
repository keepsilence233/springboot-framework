package org.example.bean.lifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * springBoot bean lifecycle
 * <p>
 * 初始化上下文 [CustomApplicationContextInitializer] initialize
 * </p>
 * <p>
 * [CustomBeanFactoryPostProcessor] 构造器
 * 执行 [CustomBeanFactoryPostProcessor#postProcessBeanFactory] 方法
 * [CustomBeanPostProcessor] 构造器
 * [CustomInstantiationAwareBeanPostProcessor] 构造器
 * </p>
 * <p>
 * Bean 实例化之前 [CustomInstantiationAwareBeanPostProcessor] before instantiation user
 * </p>
 * <p>
 * [user bean] 构造函数
 * [CustomInstantiationAwareBeanPostProcessor] postProcessPropertyValues方法 修改Bean属性值
 * [user bean 属性注入] mobile:110
 * </p>
 * <p>
 * 接口BeanNameAware#setBeanName
 * 接口ApplicationContextAware#setApplicationContext
 * </p>
 * <p>
 * Bean 初始化前 [CustomBeanPostProcessor] before initialization user
 * [user bean] @PostConstruct
 * 接口InitializingBean#afterPropertiesSet
 * [init-method]调用<bean>的init-method属性指定的初始化方法
 * Bean 初始化后 [CustomBeanPostProcessor] after initialization user
 * </p>
 * <p>
 * Bean 实例化之后[CustomInstantiationAwareBeanPostProcessor] after initialization user
 * </p>
 * <p>
 * 接口ApplicationRunner#run
 * 接口CommandLineRunner#run
 * </p>
 * <p>
 * [user bean] @PreDestroy
 * 接口DisposableBean#destroy
 * [destroy-method]调用<bean>destroy-method属性指定的销毁方法
 * </p>
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
//        SpringApplication application = new SpringApplication(Application.class);
//        application.addInitializers(new CustomApplicationContextInitializer());
//        application.run(args);
    }


    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public User user() {
        return new User("张三");
    }
}
