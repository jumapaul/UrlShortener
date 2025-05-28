package com.url_shortenning.gatewayservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class ApiGatewayController {

    @GetMapping
    public String helloWorld() {
        return "Hello world";
    }
}
