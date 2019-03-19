package com.codecool.frontendservice.controller;

import com.codecool.frontendservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String mainSite(Model model){
        model.addAttribute("question", questionService.addDailyQuestion());
        return "mainSite";
    }

}
