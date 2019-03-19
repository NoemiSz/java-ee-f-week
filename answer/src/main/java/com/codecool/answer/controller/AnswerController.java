package com.codecool.answer.controller;

import com.codecool.answer.service.AnswerService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private Environment env;

    @GetMapping("/answer")
    public Answer getAnswer(){
        return new Answer(
                answerService.getAnswer(),
                env.getProperty("server port")
        );
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor

    public class Answer{
        private String answer;
        private String port;
    }



}
