package com.example.myfirstservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class MyFirstServiceController {

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the first service";
    }
}
