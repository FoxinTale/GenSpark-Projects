package com.genspark.SpringBootDemoApplication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @GetMapping("/")
    public String home(){ // home page, basically.
        return "<html><h1> This is the home page of my first spring Boot application.. </h1></html>";
    }
}
