package com.codecool.frontendservice.controller;

import com.codecool.frontendservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class OtherController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question")
    public String dailyQuestion(){
        String q = questionService.addDailyQuestion();
        return q;
    }

}
