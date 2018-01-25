package com.learning.spring.controllers;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Log
@Controller
@RequestMapping("/rm")
public class RequestMappingController {

    @Autowired
    MappingJackson2JsonView jsonView;

    @GetMapping("/hello")
    public View hello(Model model){
        model.addAttribute("greeting","Hello Angular?");
        return this.jsonView;
    }

    @PostMapping("/hello")
    public View helloPost(@RequestParam String greeting,Model model){
        log.warning(greeting);
        model.addAttribute("msg","Server got : "+greeting);
        return this.jsonView;
    }

}
