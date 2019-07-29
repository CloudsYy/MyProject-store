package com.example.demo.Interceptor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.logging.Logger;

@Configuration
public class InterceptorToken implements WebMvcConfigurer {

    @Bean
    public MyInterceptor getMyInterceptor(){
        return new MyInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(this.getMyInterceptor())
        .addPathPatterns("/**");
    }
}
