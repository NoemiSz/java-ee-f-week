package com.codecool.questionservice.service;

import com.codecool.questionservice.Entity.Question;
import com.codecool.questionservice.Repository.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;


    public Question getQuestion(){
        int high = 19;
        int low = 1;
        Random random = new Random();
        int num = random.nextInt(high) + low;
        return questionRepository.findFirstById((long)num);
    }
}
