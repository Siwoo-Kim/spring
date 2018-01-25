package com.learning.spring.controllers;

import com.learning.spring.domain.User;
import com.learning.spring.repository.UserRepository;
import com.learning.spring.validator.UserValidator;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.validation.Valid;
import java.awt.*;
import java.util.Locale;

@Log
@Controller
@RequestMapping("/validator")
public class ValidatorController {

    @Autowired
    MappingJackson2JsonView jsonView;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserValidator userValidator;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public View submit(@Valid @RequestBody User user, BindingResult bindingResult){

        log.warning(user::toString);
        //Validator is interface for validate object properties
        userValidator.validate(user,bindingResult);
        //If the requirement of properties does not matched,
        // BindingResult will hold error code and field that does not fulfill the requirement

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().stream()
                    .map(ObjectError::getCode).forEach(log::warning);
        }

        return jsonView;
    }


    @Autowired
    MessageSource messageSource;


    @Getter @Setter @ToString
    public static class Code{
        String code;
    }

    @PostMapping("/error")
    public View messageCode(@RequestBody Code code,Locale locale,Model model){
        log.warning(code::toString);
        String message = this.messageSource.getMessage(code.getCode(),null,locale);
        model.addAttribute("error-code",message);
        return jsonView;
    }


}
