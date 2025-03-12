package com.proyecto.EasyIT.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin
public class MessageController {

    @GetMapping("/hello")
    public String hello(){
        return "full stack app con Springboot y Vue JS !";
    }
}
