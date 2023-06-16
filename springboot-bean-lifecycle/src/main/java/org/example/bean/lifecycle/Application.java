package org.example.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

/**
 * springBoot bean lifecycle
 * <p>
 * ApplicationContextInitializer
 * </p>
 * <p>
 * BeanNameAware
 * ApplicationContextAware
 * </p>
 * <p>
 * 调用Bean的函数(constructor)
 * 调用postProcessBeforeInitialization...
 * 调用Bean的函数(postConstruct)
 * 调用Bean的函数(afterPropertiesSet)
 * 调用Bean的函数(initMethod)
 * 调用postProcessAfterInitialization...
 * </p>
 * <p>
 * ApplicationRunner
 * CommandLineRunner
 * </p>
 * <p>
 * 调用Bean的函数(preDestroy)
 * 调用Bean的函数(destroy)
 * 调用Bean的函数(destroyMethod)
 * </p>
 */
@SpringBootApplication
public class Application implements ApplicationRunner, CommandLineRunner, BeanNameAware, ApplicationContextAware {
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

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunner +" + args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunner +" + args);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware");
    }
}
