package com.pucrs.sistemas.vestibulandos.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {

        return "home/index";
    }

    @GetMapping("/outro")
    public String indexOutraPasta() {

        return "outrapasta/index";
    }
}
