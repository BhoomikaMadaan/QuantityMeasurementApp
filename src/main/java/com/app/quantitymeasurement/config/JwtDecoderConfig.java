package com.app.quantitymeasurement.config;

import javax.crypto.SecretKey;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class JwtDecoderConfig {

    @Value("${app.jwt.secret}")
    private String secret;

    @Bean
    JwtDecoder jwtDecoder() {

        SecretKey key =
                Keys.hmacShaKeyFor(
                        secret.getBytes());

        return NimbusJwtDecoder
                .withSecretKey(key)
                .build();
    }
}
