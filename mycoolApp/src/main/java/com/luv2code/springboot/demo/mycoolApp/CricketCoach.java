package com.luv2code.springboot.demo.mycoolApp;

import org.springframework.stereotype.Component;

@Component//marks the class as spring bean // makes it a candidate for dependecy injection
public class CricketCoach implements  Coach{

    @Override
    public String getDailyWorkOut() {
        return "Practice fast bowling for 15 mins!!!!!";

    }
}
