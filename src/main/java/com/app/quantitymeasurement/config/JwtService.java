package com.app.quantitymeasurement.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    @Value("${app.jwt.secret}")
    private String secret;

    @Value("${app.jwt.expiration}")
    private long expiration;

    public String generateToken(
            String email,
            String name,
            String picture) {

        SecretKey key =
                Keys.hmacShaKeyFor(
                        secret.getBytes());

        return Jwts.builder()

                .setSubject(email)

                .claim("name", name)

                .claim("picture", picture)

                .setIssuedAt(
                        new Date())

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + expiration))

                .signWith(key)

                .compact();
    }
}