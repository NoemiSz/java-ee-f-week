package com.codecool.frontendservice.service;

import com.codecool.frontendservice.model.Answer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AnswerService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${answer.url}")
    private String baseUrl;

    public String addActualAnswer() {
        Answer actualAnswer = restTemplate.getForEntity(baseUrl + "/answer", Answer.class).getBody();
        System.out.println(actualAnswer.getAnswer());
        return actualAnswer.getAnswer();
    }

}
