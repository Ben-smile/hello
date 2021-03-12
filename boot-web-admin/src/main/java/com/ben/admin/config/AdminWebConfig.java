package com.ben.admin.config;

import com.ben.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//说明这是个配置类
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截所有请求
                .excludePathPatterns("/", "/login", "/css/**", "/fonts/**",
                        "/images/**", "/js/**");//需要放行的请求
    }
}
