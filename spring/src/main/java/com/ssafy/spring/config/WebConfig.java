package com.ssafy.spring.config;

import com.ssafy.spring.interceptor.JWTInterceptor;
import com.ssafy.spring.interceptor.SignupInterceptor;
import com.ssafy.spring.resolver.ClientIpArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }

    @Autowired
    private ClientIpArgumentResolver clientIpArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(clientIpArgumentResolver);
    }

    @Autowired
    private JWTInterceptor jwtInterceptor;

    @Autowired
    private SignupInterceptor signupInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        // 카카오 토큰 확인
//        registry.addInterceptor(jwtInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/auth/**", "/error/**") // 로그인 과정에 필요한 api 호출들 제외
//                .excludePathPatterns("/swagger-resources/**", "/swagger-ui/**", "/v2/api-docs"); // 스웨거 관련 경로 제외
//
////        // 설문 가입 여부 확인
//        registry.addInterceptor(signupInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/auth/**", "/user/signup", "/user/check/**", "/error/**")
//                .excludePathPatterns("/swagger-resources/**", "/swagger-ui/**", "/v2/api-docs"); // 스웨거 관련 경로 제외
    }
}
