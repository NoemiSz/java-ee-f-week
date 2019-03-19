package com.codecool.frontendservice.service;

import com.codecool.frontendservice.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class QuestionService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${question.url}")
    private String baseUrl;

    public String addDailyQuestion() {
        Question dailyQuestion = restTemplate.getForEntity(baseUrl + "/question", Question.class).getBody();
        return dailyQuestion.getQuestionBody();
    }

}
