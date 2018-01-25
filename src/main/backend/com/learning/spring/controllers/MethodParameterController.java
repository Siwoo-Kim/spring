package com.learning.spring.controllers;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Log
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
        }else if(cookiedName != name) {
            Cookie cookie = new Cookie("cookiedName",name);
            response.addCookie(cookie);
            model.addAttribute("msg1","Cookie is changed My, "+name+" !");
        }else{
            model.addAttribute("msg1","Good to see you again, "+cookiedName);
        }
        return this.jsonView;
    }

    @GetMapping("/httpServlet")
    public void httpServlet(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws IOException {

        Map map = httpServletRequest.getParameterMap();

        map.forEach((key,value) -> {
            log.warning("key : "+key+", value : "+map.get(key));
        });

        httpServletResponse.getWriter().println("This is from httpServetResponse");

    }

    @GetMapping("/path/{id}")
    public View pathVarialbe(@PathVariable("id") Long id, Model model){
        log.warning(id.toString());
        log.warning("Server got id : "+id.toString());
        model.addAttribute("id",id);
        return this.jsonView;
    }
}

