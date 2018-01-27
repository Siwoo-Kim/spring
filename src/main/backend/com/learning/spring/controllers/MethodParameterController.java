package com.learning.spring.controllers;

import io.netty.util.internal.ObjectUtil;
import lombok.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.util.UriComponentsBuilder;

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

    @Getter @Setter @ToString @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class ParamUser{
        Long id;
        String name;
        String email;
    }

    @GetMapping("/three")
    public  View threeParams(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            Model model
    ){

        log.warning(id.toString());
        log.warning(name);
        log.warning(email);

        model.addAttribute(ParamUser.builder().email(email).name(name).id(id).build());
        return this.jsonView;
    }

    @GetMapping("/create/cookie")
    public View createCookie(@RequestParam("name") String name, HttpServletResponse response, UriComponentsBuilder uriComponentsBuilder){
        Cookie cookie = new Cookie("name",name);
        cookie.setPath("/");
        response.addCookie(cookie);
        return this.jsonView;
    }

    @GetMapping("/cookie")
    public View cookie(
            @CookieValue(value="name",
                    required=false, defaultValue="GUEST")
                    String nameCookie,Model model){

        if(StringUtils.hasText(nameCookie) && !nameCookie.equals("GUEST")) {
            log.warning(nameCookie);
            model.addAttribute("savedCookie",nameCookie);
            return this.jsonView;
        }

        model.addAttribute("noCookie",nameCookie);
        return this.jsonView;
    }


    @GetMapping("/header")
    public View getHeader(
            @RequestHeader("Host") String host,
            @RequestHeader("Keep-Alive") long keepAlive,
            @RequestHeader("Content-Type") String contentType,
            Model model){

        Map<String,Object> map = new HashMap<>();

        map.put("host",host);
        map.put("Keep-Alive",keepAlive);
        map.put("Content-Type",contentType);

        model.addAttribute("header",map);
        return this.jsonView;
    }


}

