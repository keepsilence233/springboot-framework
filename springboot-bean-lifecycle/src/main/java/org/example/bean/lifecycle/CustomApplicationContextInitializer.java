package org.example.bean.lifecycle;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 整个spring容器在刷新之前初始化ConfigurableApplicationContext的回调接口，简单来说，就是在容器刷新之前调用此类的initialize方法
 */
@Component
public class CustomApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    /**
     * 可以在这个方法中添加您想要的配置或者修改Bean，从而实现对Spring Boot应用程序的定制。
     *
     * @param applicationContext {@link ConfigurableApplicationContext}
     */
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer");
    }
}
