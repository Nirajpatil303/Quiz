package com.Question.Question.Service;

import com.Question.Question.Enttity.Question;
import com.Question.Question.Enttity.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Questionservice {

    @Autowired
    private QuestionRepo questionRepo;


    public Question getbyid(Long id){
        return questionRepo.findById(id).orElseThrow(()-> new RuntimeException(" Question not found !!"));
    }

    public List<Question> getall(){
        return questionRepo.findAll();
    }

    public Question addquestion( Question question) {
        return questionRepo.save(question);
    }

    public List<Question> findbyQuizid (Long quizid){
        return questionRepo.findByQuizid(quizid);
    }

}
