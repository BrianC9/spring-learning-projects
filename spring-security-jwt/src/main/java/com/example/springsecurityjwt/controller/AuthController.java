package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is going to contain a single POST method that will use your new token service to generate a token for the authenticated user.
 * As you can see there is some logging for debugging purposes so that in development you will see the user requesting a JWT and the token that was created.
 */
@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
        LOG.debug("Se ha solicitado un Token para el usaurio: '{}' ", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token concedido {}", token);
        return token;
    }

}
