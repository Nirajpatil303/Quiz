package com.Quiz.Quiz.Controller;

import com.Quiz.Quiz.Entity.Quiz;
import com.Quiz.Quiz.Service.quizservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Quiz")
public class quizcontroller {

    @Autowired
    private quizservice quizservice;

    @GetMapping("/{id}")
    public @ResponseBody Quiz getbyid(@PathVariable Long id){
        return quizservice.getbyid(id);
    }


    @GetMapping
    public @ResponseBody List<Quiz> getall(){
        return quizservice.getall();
    }



    @PostMapping
    public @ResponseBody Quiz addquestion(@RequestBody Quiz quiz ) {
        return quizservice.addquestion(quiz);
    }
}
