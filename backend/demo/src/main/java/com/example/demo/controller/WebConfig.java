package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Libera todos os caminhos
                .allowedOrigins("http://localhost:4200") // Origem do Angular
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos liberados
                .allowedHeaders("*") // Libera todos os cabeçalhos
                .allowCredentials(false);
    }
}