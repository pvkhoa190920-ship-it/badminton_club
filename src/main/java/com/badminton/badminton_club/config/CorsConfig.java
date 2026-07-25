package com.badminton.badminton_club.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Cấp quyền cho toàn bộ API
                .allowedOrigins("*") // Tạm thời để "*" cho phép mọi nơi gọi tới. Khi lên online, thay bằng link Frontend thật (VD: "https://web-badminton.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }
}