package hello.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/v1/coffees")
public class HomeController {

    @GetMapping
    public String getCoffee(HttpSession session, HttpServletRequest httpServletRequest){

        System.out.println(session.getId());
        return "coffee";
    }
}
