package com.codecool.questionservice.Repository;

import com.codecool.questionservice.Entity.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void getQuestions(){
        Question q1 = Question.builder()
                .questionBody("Saturday Night Live")
                .build();
        questionRepository.save(q1);

        List<Question> questionList = questionRepository.findAll();
        System.out.println(questionList.toString());
        assertThat(questionList).hasSize(1);
        assertEquals(1,questionList.size());

    }

}

