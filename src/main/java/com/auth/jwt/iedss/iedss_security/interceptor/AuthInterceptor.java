package com.auth.jwt.iedss.iedss_security.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;


public class AuthInterceptor implements RequestInterceptor {
    @Bean
    AuthInterceptor authFeign() {
        return new AuthInterceptor();
    }
    @Override
    public void apply(RequestTemplate template) {
        template.header("Authorization", "<your token>");

    }

}