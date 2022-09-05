package com.baeldung.spring.rest.compress;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class Test implements InitializingBean {
    @Autowired
    ApplicationContext context;
    @Autowired
    static SimpleDateFormat formatter;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(context.containsBean("formatter") + " ");
        System.out.println(context.getBean("formatter").getClass());
        System.out.println(formatter.getClass());
        System.out.println(context.getClass());
    }
}

@Configuration
class TestConfig {
    @Bean
    public SimpleDateFormat formatter() {
        return new SimpleDateFormat();
    }
}