package com.app.quantitymeasurement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping(
            "/api/auth/success")
    public String success(
            @RequestParam
            String token) {

        return "JWT Token : "
                + token;
    }
}