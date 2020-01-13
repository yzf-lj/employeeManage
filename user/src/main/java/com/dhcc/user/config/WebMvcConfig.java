package com.dhcc.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yzf
 * @create 2020-01-13 15:16
 */

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHanderInterceptor())
                .addPathPatterns("/**").excludePathPatterns(
                        "/","/user/login","static/**",
                "/static/font/**", "/static/fonts/**",
                "/static/js/**", "/static/css/**", "img/**");
    }
}
