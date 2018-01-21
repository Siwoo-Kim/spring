package com.learning.spring.validator;

import com.learning.spring.domain.User;
import com.learning.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return (User.class.isAssignableFrom(clazz));
    }

    @Transactional(readOnly = true)
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","required.user.email");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","required.user.name");


        if(userRepository.existsByEmail(user.getEmail())){
            errors.rejectValue("email","duplicate.user.emai",new Object[]{user.getEmail()},"User Email is duplicated");
        }

    }

}
