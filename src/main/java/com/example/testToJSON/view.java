package com.example.testToJSON;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class view {


    @GetMapping("/")
    public String returnView(){

        return "System";
    }

}
