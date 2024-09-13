package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.CourseCategory;
import com.example.OnlineLearningSystem.model.Quiz;
import com.example.OnlineLearningSystem.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class QuizController {
    private QuizService quizService;

    @PostMapping("/courses/quizzes")
    public ResponseEntity<RespnseMessage> createQuiz(@RequestBody Quiz request,@RequestParam String course_id){
        RespnseMessage message=quizService.createQuiz(request,course_id);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/public/courses/quizzes")
    public ResponseEntity<List<Quiz>> getquzzies(@RequestParam String course_id){
        List<Quiz> quizzes=quizService.getQuizByCourseID(course_id);
        return new ResponseEntity<>(quizzes,HttpStatus.OK);
    }


    @DeleteMapping("/courses/quizzes/{id}")
    public ResponseEntity <RespnseMessage> deleteQuiz(@PathVariable int id){
        RespnseMessage message=quizService.deleteQuiz(id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PutMapping("/courses/quizzes/{id}")
    public ResponseEntity <RespnseMessage> updateQuiz(@PathVariable int id,@RequestBody Quiz request){
        RespnseMessage message=quizService.updateQuiz(id,request);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }


}
