package com.Quiz.Quiz.Service;

import com.Quiz.Quiz.Entity.Question;
import com.Quiz.Quiz.Entity.Quiz;
import com.Quiz.Quiz.Entity.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class quizservice {

    private final QuizRepo quizRepo;
    private final Questionclient questionclient;

    @Autowired
    public quizservice(QuizRepo quizRepo, Questionclient questionclient) {
        this.quizRepo = quizRepo;
        this.questionclient = questionclient;
    }


    public Quiz getbyid(Long id){
        Quiz quiz = quizRepo.findById(id).orElseThrow(()-> new RuntimeException(" Quiz not found !!"));
        quiz.setQuestions(questionclient.findByQuizid(quiz.getId()));
        return quiz;
    }

    public List<Quiz> getall(){
        List<Quiz> quizList = quizRepo.findAll();
        List<Quiz> quizreturn = new ArrayList<>();
        for (Quiz quiz :quizList){
            quiz.setQuestions(questionclient.findByQuizid(quiz.getId()));
            quizreturn.add(quiz);

        }

        return quizreturn;
    }

    public Quiz addquestion( Quiz quiz) {
        return quizRepo.save(quiz);
    }


}
