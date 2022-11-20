package com.uniktech.api.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallbacks")
public class FallbackController {

    @GetMapping("/userServiceFallback")
    public String userServiceFallbackMethod() {
        return "User service down..!!";
    }

    @GetMapping("/departmentServiceFallback")
    public String departmentServiceFallbackMethod() {
        return "Department service down..!!";
    }

    @GetMapping("/persistorServiceFallback")
    public String persistorServiceFallbackMethod() { return "Persistor down..!!"; }
}
