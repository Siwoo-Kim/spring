package com.learning.spring.controllers;

import com.learning.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

// This class is for learning WebDataBinder

@RestController
@SessionAttributes("editUser")
@RequestMapping("/webdata_binder/")
public class WebDataBinderController {

    @Autowired
    MappingJackson2JsonView jsonView;

    @Autowired
    UserRepository userRepository;

    //WebDataBinder는 HTTP 요청정보를 컨트롤러 메소드의 파라미터나 모델에 바인딩할때 사용하는 오브젝트.
    //WebDataBinder is used for binding throw parameter in controller method

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        //Set the allowed property throw WebDataBinder
        dataBinder.setAllowedFields("name","address","age");
    }


    @GetMapping("/{id}")
    public View getUser(@PathVariable("id") Long id,Model model){
        model.addAttribute(this.userRepository.findById(id).get());
        return  this.jsonView;
    }

    public void edit(){

    }

}
