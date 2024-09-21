package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.QuestionAnswer;
import com.example.OnlineLearningSystem.model.StudentSubmission;
import com.example.OnlineLearningSystem.service.StudentSubmissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StudentSubmissionController {
    private StudentSubmissionService studentSubmissionService;

    @PostMapping("/student/courses/quizzes/submissions")
    public ResponseEntity<RespnseMessage> submitQuiz(@RequestBody StudentSubmission request, @RequestParam String quizId,@RequestParam String studentId ){
        RespnseMessage message=studentSubmissionService.submitAnswers(request,studentId,quizId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
