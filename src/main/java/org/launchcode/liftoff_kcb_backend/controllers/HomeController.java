package org.launchcode.liftoff_kcb_backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("index")
public class HomeController {

    @GetMapping
    public String index() { return "index";
    }

}