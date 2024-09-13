package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.QuizQuestion;
import com.example.OnlineLearningSystem.service.QuizQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class QuizQuestionController {
    private QuizQuestionService quizQuestionService;

    @PostMapping("/courses/quizzes/question")
    public ResponseEntity<RespnseMessage> addQuestion(@RequestBody QuizQuestion request, @RequestParam String quizId ){
        RespnseMessage message=quizQuestionService.createQuestion(request,quizId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    @DeleteMapping("/courses/quizzes/question/{id}")
    public ResponseEntity<RespnseMessage> deleteQuestion(@PathVariable int id ){
        RespnseMessage message=quizQuestionService.deleteQuestion(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
