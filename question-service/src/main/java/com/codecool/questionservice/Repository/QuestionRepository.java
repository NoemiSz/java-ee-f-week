package com.codecool.questionservice.Repository;

import com.codecool.questionservice.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository <Question,Long> {
}
