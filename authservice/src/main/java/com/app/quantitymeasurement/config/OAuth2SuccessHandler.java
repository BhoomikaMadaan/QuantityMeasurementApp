package com.app.quantitymeasurement.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuth2SuccessHandler
        implements AuthenticationSuccessHandler {

    private final JwtService jwtService;

    public OAuth2SuccessHandler(
            JwtService jwtService) {

        this.jwtService = jwtService;
    }

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication)
            throws IOException,
            ServletException {

        OAuth2User user =
                (OAuth2User) authentication
                        .getPrincipal();

        String email =
                user.getAttribute("email");

        String name =
                user.getAttribute("name");

        String picture =
                user.getAttribute("picture");

        String token =
                jwtService.generateToken(
                        email,
                        name,
                        picture);
//        response.setContentType("text/plain");
//
//        response.getWriter()
//                .write("JWT Token : " + token);
        response.sendRedirect("http://localhost:5173/?token=" + token);
    }
}