package com.app.quantitymeasurement.gateway;

import java.util.Enumeration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

/**
 * The existing React frontend (qm-react-frontend) was built against a
 * single Spring Boot monolith on port 8080 and hard-codes that base URL
 * for BOTH auth calls and quantity calls (see .env / src/services/api.js).
 *
 * Since the frontend is being kept exactly as-is, this thin gateway lives
 * in authservice (port 8080) and simply forwards every /api/quantity/**
 * request on to quantityservice (port 8081), which owns all the real
 * quantity-measurement logic. No business logic lives here - it is pure
 * pass-through so the two services stay independently deployable.
 */
@RestController
public class QuantityGatewayController {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${quantityservice.base-url}")
    private String quantityServiceBaseUrl;

    @RequestMapping("/api/quantity/**")
    public ResponseEntity<byte[]> forwardToQuantityService(
            HttpServletRequest request,
            @RequestBody(required = false) byte[] body) {

        String path = request.getRequestURI();
        String query = request.getQueryString();

        String targetUrl = quantityServiceBaseUrl + path
                + (query != null ? "?" + query : "");

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) {

            String name = headerNames.nextElement();

            if (name.equalsIgnoreCase("host")
                    || name.equalsIgnoreCase("content-length")) {
                continue;
            }

            Enumeration<String> values = request.getHeaders(name);

            while (values.hasMoreElements()) {
                headers.add(name, values.nextElement());
            }
        }

        HttpMethod method = HttpMethod.valueOf(request.getMethod());

        HttpEntity<byte[]> entity = new HttpEntity<>(body, headers);

        return restTemplate.exchange(
                targetUrl,
                method,
                entity,
                byte[].class);
    }
}
