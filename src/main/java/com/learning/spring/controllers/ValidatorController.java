package com.learning.spring.controllers;

import com.learning.spring.domain.User;
import com.learning.spring.repository.UserRepository;
import com.learning.spring.validator.UserValidator;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.validation.Valid;
import java.awt.*;

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



}
