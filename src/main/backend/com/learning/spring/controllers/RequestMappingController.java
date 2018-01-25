package com.learning.spring.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping(value = "/params",params = "type=member")
    public View paramsMember(@RequestParam String type,Model model){
        log.warning(type);
        model.addAttribute("msg2","Server got : "+type);
        return this.jsonView;
    }

    @GetMapping(value = "/params",params = "type=admin")
    public View paramsAdmin(@RequestParam String type,Model model){
        log.warning(type);
        model.addAttribute("msg2","Server got : "+type);
        return this.jsonView;
    }

    @GetMapping(value="/headers")
    public View headers(@RequestHeader HashMap map, Model model){

        map.forEach( (entry,key) -> {
            log.warning(entry.toString());
            log.warning(key.toString());
        } );

        model.addAttribute("headers",map);
        return this.jsonView;
    }


}
