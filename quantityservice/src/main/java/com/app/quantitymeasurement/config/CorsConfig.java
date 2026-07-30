package com.app.quantitymeasurement.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * quantityservice has no login/security requirement of its own (auth is
 * handled entirely by authservice), so this simply reproduces the
 * permissive CORS behaviour that the original monolith's
 * SecurityConfig.corsConfigurationSource() provided.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
