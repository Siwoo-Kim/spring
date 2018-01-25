package com.learning.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping("/rm")
public class RequestMappingController {

    @Autowired
    MappingJackson2JsonView jsonView;

    @RequestMapping("/hello")
    public View hello(Model model){
        model.addAttribute("greeting","Hello Angular?");
        return this.jsonView;
    }
}
