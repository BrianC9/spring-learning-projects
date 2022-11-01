package com.example.springsecurityjwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloController {
    @GetMapping()
    public String hello(Principal principal) {

        return "Hello " + principal.getName();
    }
    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('SCOPE_read')")
    public String admin(){
        return "Hello Admin!";
    }

}
