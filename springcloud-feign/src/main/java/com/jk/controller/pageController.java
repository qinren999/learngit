package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class pageController {
    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
    }
}
