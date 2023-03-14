package com.example.springmvc.controller;

import com.example.springmvc.dto.UserDTO;
import com.example.springmvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Scanner;

@Controller
public class RegisterController {
    private static final Logger log = LoggerFactory.getLogger(RegisterController.class);
    private final UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView registerGet(@ModelAttribute UserDTO userDTO) {
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("userDTO", userDTO);
        modelAndView.setViewName("register/dist/register");
        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView save(@Valid UserDTO userDTO , BindingResult bindingResult) {
        ModelAndView modelAndView=new ModelAndView();

        if(userService.userExist(userDTO.getEmail())){
            bindingResult.addError(new FieldError("userDTO","email",
                    "Email address already use"));
        }
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("register/dist/register");
            return modelAndView;
        }
        modelAndView.setViewName("login/dist/login");
        userService.register(userDTO);
        System.out.println(bindingResult.hasErrors());
        log.info(">> userDTO :{}",userDTO.toString());
        return modelAndView;
    }
}
