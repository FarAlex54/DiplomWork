package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
        @Value("${hello_world}") //дергаем переменную из файла "application.properties"
        private String HelloWorld;
        @GetMapping("/hello/world")
        private void HelloWorld(){
            System.out.println(HelloWorld);
        }
}
