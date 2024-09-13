package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.CourseCategory;
import com.example.OnlineLearningSystem.service.CourseCategoryService;
import com.example.OnlineLearningSystem.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CourseController {
   private CourseService courseService;

    @PostMapping("/courses")
    public ResponseEntity<RespnseMessage> createCourse(@RequestBody Course request,@RequestParam String instructor_id,@RequestParam String category_id ){
        RespnseMessage message=courseService.createCourse(request,instructor_id,category_id);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/public/courses")
    public ResponseEntity<List<Course>> getCourses(){
        List<Course> courses=courseService.getCourses();
        return new ResponseEntity<>(courses,HttpStatus.OK);
    }

    @GetMapping("/public/courses/{id}")
    public ResponseEntity<Course> getCategory(@PathVariable int id ){
        Course course=courseService.getCourse(id);
        return new ResponseEntity<>(course,HttpStatus.OK);

    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity <RespnseMessage> deleteCourse(@PathVariable int id,@RequestParam String instructor_id){
        RespnseMessage message=courseService.deleteCourse(id,instructor_id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity <RespnseMessage> updateCourse(@PathVariable int id,Course request,@RequestParam String instructor_id,@RequestParam String category_id ){
        RespnseMessage message=courseService.updateCourse(id,request,instructor_id,category_id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
