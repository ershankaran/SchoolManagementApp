package com.shankar.schoolmanagementapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    

    @GetMapping("/")
    public String displayHomePage(){
        return "index.html";
    }
}
