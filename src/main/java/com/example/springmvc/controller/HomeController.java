package com.example.springmvc.controller;

import com.example.springmvc.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homeGet(@ModelAttribute UserDTO userDTO, Model model) {
        model.addAttribute("userDTO", userDTO);
        return "home/dist/home";
    }
    @PostMapping("/home")
    public String homePost(){
        return "home/dist/home";
    }
}
