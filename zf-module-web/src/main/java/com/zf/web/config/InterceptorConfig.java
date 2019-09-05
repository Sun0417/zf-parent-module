package com.zf.web.config;

import com.zf.web.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册拦截器不是 Configurable 而是 Configuration
 * 配置拦截器
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/28
 * Time: 17:17
 * Description: No Description
 */
@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {

    @Autowired
    AuthenticationInterceptor authenticationInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**");
    }


}
