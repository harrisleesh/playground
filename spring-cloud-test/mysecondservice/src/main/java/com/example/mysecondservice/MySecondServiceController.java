package com.example.mysecondservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/second-service")
public class MySecondServiceController {

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the my second service";
    }
}
