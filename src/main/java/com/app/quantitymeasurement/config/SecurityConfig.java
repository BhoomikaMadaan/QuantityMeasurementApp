package com.app.quantitymeasurement.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.security.config.Customizer;
@Configuration
public class SecurityConfig {

    private final OAuth2SuccessHandler successHandler;

    public SecurityConfig(
            OAuth2SuccessHandler successHandler) {

        this.successHandler =
                successHandler;
    }

    
    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http)
            throws Exception {

        http
                .csrf(
                        csrf -> csrf.disable())
                .cors(Customizer.withDefaults()) 

                .authorizeHttpRequests(
                        auth -> auth
                                .anyRequest()
                                .permitAll())

                .oauth2Login(
                        oauth -> oauth
                                .successHandler(
                                        successHandler));

        http.headers(
                headers -> headers
                        .frameOptions(
                                frame ->
                                        frame.disable()));
        

        return http.build();
    }
    
    @Bean
    public CorsConfigurationSource
    corsConfigurationSource() {

        CorsConfiguration config =
                new CorsConfiguration();

        config.addAllowedOrigin("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration(
                "/**",
                config);

        return source;
    }
    }
