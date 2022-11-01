package com.example.springsecurityjwt.controller;

import com.example.springsecurityjwt.model.LoginRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springsecurityjwt.service.TokenService;
/**
 * This is going to contain a single POST method that will use your new token service to generate a token for the authenticated user.
 * As you can see there is some logging for debugging purposes so that in development you will see the user requesting a JWT and the token that was created.
 */
@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public String token(@RequestBody LoginRequest userLogin) {
        System.out.println(userLogin);

        LOG.debug("Se ha solicitado un Token para el usaurio: '{}' ", userLogin.username());
        System.out.println("Se ha solicitado un Token para el usaurio: "+ userLogin.username());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.username(), userLogin.password()));
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token concedido {}", token);
        return token;
    }

}
