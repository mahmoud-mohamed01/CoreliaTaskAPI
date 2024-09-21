package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Enrollment;
import com.example.OnlineLearningSystem.model.StudentSubmission;
import com.example.OnlineLearningSystem.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EnrollmentController{
    private EnrollmentService enrollmentService;
    @PostMapping("/student/courses/enrollments")
    public ResponseEntity<RespnseMessage> enrollToCourse(@RequestParam String studentId, @RequestParam String courseId ){
        RespnseMessage message=enrollmentService.enrollStudentToCourse(studentId,courseId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/student/courses/enrollments")
    public ResponseEntity<List<Enrollment>> getStudentEnrollments(@RequestParam String studentId){
        List<Enrollment> enrollments=enrollmentService.getStudentCourses(studentId);
        return new ResponseEntity<>(enrollments, HttpStatus.OK);
    }



}
