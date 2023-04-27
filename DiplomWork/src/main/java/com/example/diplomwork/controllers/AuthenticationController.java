package com.example.diplomwork.controllers;

import com.example.diplomwork.models.Product;
import com.example.diplomwork.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/authentication")
    public String login(){
        return "authentication";
    }
}

//fd