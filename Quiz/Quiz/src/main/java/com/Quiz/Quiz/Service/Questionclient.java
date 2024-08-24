package com.Quiz.Quiz.Service;

import com.Quiz.Quiz.Entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(url = "http://localhost:8181",value = "Question-Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface Questionclient {

    @GetMapping("/Question/question/{quizid}")
    List<Question>  findByQuizid (@PathVariable Long quizid);
}
