package com.Question.Question.Controller;


import com.Question.Question.Enttity.Question;
import com.Question.Question.Service.Questionservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Question")
public class Questioncontroller {

    @Autowired
    private Questionservice questionservice;

    @GetMapping("/{id}")
    public @ResponseBody Question getbyid(@PathVariable Long id){
        return questionservice.getbyid(id);
    }

    @GetMapping("question/{quizid}")
    public @ResponseBody List<Question> getbyquizid(@PathVariable Long quizid){
        return questionservice.findbyQuizid(quizid);
    }

    @GetMapping
    public @ResponseBody List<Question> getall(){
        return questionservice.getall();
    }



    @PostMapping
    public @ResponseBody Question addquestion(@RequestBody Question question ) {
        return questionservice.addquestion(question);
    }
}
