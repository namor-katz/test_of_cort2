package com.example.demo.controllers.simple;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootSimpleController {

    @GetMapping("/")
    public String getMainPate() {
        return "main";
    }
}
