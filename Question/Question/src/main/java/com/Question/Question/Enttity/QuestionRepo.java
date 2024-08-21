package com.Question.Question.Enttity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question,Long> {
    List<Question> findByQuizid (Long quizid);
}
