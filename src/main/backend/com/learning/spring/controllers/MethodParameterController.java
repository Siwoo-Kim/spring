package com.learning.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/mp")
public class MethodParameterController {

    @Autowired
    MappingJackson2JsonView jsonView;

    @GetMapping("/complex")
    public View complex(@RequestParam("name")String name,
                        @CookieValue(value="cookiedName",required = false)
                                  String cookiedName,
                        Model model, HttpServletResponse response
                          ){

        if(!StringUtils.hasText(cookiedName)){
            Cookie cookie = new Cookie("cookiedName",name);
            response.addCookie(cookie);
            model.addAttribute("msg1","Greeting New Vister, "+name+" !");
        }else{
            model.addAttribute("msg1","Good to see you again, "+cookiedName);
        }
        return this.jsonView;
    }
}
