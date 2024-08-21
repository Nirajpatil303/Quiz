package com.Quiz.Quiz.Service;

import com.Quiz.Quiz.Entity.Quiz;
import com.Quiz.Quiz.Entity.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class quizservice {

    @Autowired
    private QuizRepo quizRepo;


    public Quiz getbyid(Long id){
        return quizRepo.findById(id).orElseThrow(()-> new RuntimeException(" Quiz not found !!"));
    }

    public List<Quiz> getall(){
        return quizRepo.findAll();
    }

    public Quiz addquestion( Quiz quiz) {
        return quizRepo.save(quiz);
    }


}
