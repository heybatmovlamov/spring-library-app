package com.example.springmvc.controller;

import com.example.springmvc.dto.UserDTO;
import com.example.springmvc.entity.User;
import com.example.springmvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    public final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login")
    public String loginGet(@ModelAttribute UserDTO userDTO, Model model) {
        model.addAttribute("userDTO", userDTO);
        return "login/dist/login";
    }

    @PostMapping("login")
    public ModelAndView  loginPost(@Valid UserDTO userDTO, BindingResult bindingResult) {
        ModelAndView model = new ModelAndView();
       if(userService.existsPasswordAndEmail(userDTO.getEmail(),userDTO.getPassword())){
               model.setViewName("home/dist/home");
               return model;
       }
       model.setViewName("login/dist/login");
        return model;
    }

}
