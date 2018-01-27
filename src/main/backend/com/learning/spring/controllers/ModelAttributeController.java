package com.learning.spring.controllers;

import lombok.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Log
@Controller
@RequestMapping("/ma")
public class ModelAttributeController {

    @Autowired
    MappingJackson2JsonView jsonView;

    @Getter @Setter @ToString @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class UserSearch{
        private Long id;
        private String name;
        private Level level;
        private String email;

        public enum Level{
            GOLD, SILVER, BRONZE
        }
    }

    @GetMapping
    public View search(@ModelAttribute("userSearch") UserSearch userSearch){

        log.warning(userSearch::toString);

        return this.jsonView;
    }
}
