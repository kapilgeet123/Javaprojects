package com.luv2code.springboot.demo.mycoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    @Value("${coach.team}")
    private String coachTeam;
    //expose "/ that return Hello World
    @GetMapping("/")
    public String sayHello()
    {
        return "Hello Ram! hOW ARE YOU ?" + coachName + " " + coachTeam;
    }
}
