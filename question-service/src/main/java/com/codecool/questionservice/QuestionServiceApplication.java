package com.codecool.questionservice;

import com.codecool.questionservice.Entity.Question;
import com.codecool.questionservice.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class QuestionServiceApplication {
    @Autowired
    private QuestionRepository questionRepository;

    public static void main(String[] args) {
        SpringApplication.run(QuestionServiceApplication.class, args);

    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {


        return args -> {
            List<String> questionList = new ArrayList<String>(Arrays.asList("If you could switch two movie characters, what switch would lead to the most inappropriate movies?",
                "If you had to change your name, what would your new name be, and why would you choose that name?",
                "Say one thing you learn on your own.",
                "What “old person” things do you do?",
                "What are you most grateful for in this week?",
                "What band/song title describes your mood today morning?",
                "What compliments have you received lately?",
                "What fantasy world would you like to visit the most?",
                "What game have you spent the most hours playing?",
                "What is the best and worst purchases you’ve ever made?",
                "What is the gig or movie you are looking forward to the most?",
                "What is the last dream you remember of?",
                "What is your earliest memory?",
                "What is your favorite season for vacation?",
                "What is your favourite animal/pet?",
                "What is your favourite colour?",
                "What is your favourite concert experience?",
                "What is your favourite Disney character?",
                "What is your favourite housework?"));

            for(String question : questionList) {
                Question q1 = Question.builder()
                        .questionBody(question)
                        .build();
                questionRepository.save(q1);
            }
        };
    }


}
