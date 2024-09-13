package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.service.StudentProgressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class StudentProgressController {
    private StudentProgressService studentProgressService;
    @PostMapping("/studentProgress")
    public ResponseEntity<RespnseMessage> markLessonToComplete(@RequestParam String student_id, @RequestParam String lesson_id ){
        RespnseMessage message=studentProgressService.checkLessonToComplete(student_id,lesson_id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
