package com.codecool.questionservice.controller;

import com.codecool.questionservice.Entity.Question;
import com.codecool.questionservice.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@Controller
@Slf4j
@RequestMapping("/")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private Environment env;

    @GetMapping("/question")
    public Question oneQuestion(){
        return questionService.getQuestion();
    }

}
