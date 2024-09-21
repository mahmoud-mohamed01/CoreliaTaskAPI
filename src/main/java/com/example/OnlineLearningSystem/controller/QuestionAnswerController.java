package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.QuestionAnswer;
import com.example.OnlineLearningSystem.model.QuizQuestion;
import com.example.OnlineLearningSystem.service.QuestionAnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class QuestionAnswerController {
    private QuestionAnswerService questionAnswerService;

    @PostMapping("/courses/quizzes/question/answers")
    public ResponseEntity<RespnseMessage> addAnswer(@RequestBody QuestionAnswer request, @RequestParam String questionId ){
        RespnseMessage message=questionAnswerService.createAnswer(request,questionId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/courses/quizzes/question/answers/{id}")
    public ResponseEntity<RespnseMessage> deleteAnswer(@PathVariable int id ){
        RespnseMessage message=questionAnswerService.deleteAnswer(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
