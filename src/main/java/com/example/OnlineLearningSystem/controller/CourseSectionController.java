package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.CourseSection;
import com.example.OnlineLearningSystem.service.CourseSectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CourseSectionController {
    private CourseSectionService courseSectionService;


    @PostMapping("/courses/sections")
    public ResponseEntity<RespnseMessage> createSection(@RequestBody CourseSection request, @RequestParam int course_id ){
        RespnseMessage message=courseSectionService.createCourseSection( request,course_id);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/courses/sections")
    public ResponseEntity<List<CourseSection>> getAllSectionsByCourse(@RequestParam int course_id){
        List<CourseSection> courseSections=courseSectionService.getCourseSectionbyCourse(course_id);
        return new ResponseEntity<>(courseSections,HttpStatus.OK);
    }

    @GetMapping("/courses/sections/{section_id}")
    public ResponseEntity<CourseSection> getSection(@PathVariable int section_id ){
        CourseSection section=courseSectionService.getCourseSection(section_id);
        return new ResponseEntity<>(section,HttpStatus.OK);

    }

    @DeleteMapping("/courses/sections/{section_id}")
    public ResponseEntity <RespnseMessage> deleteSection(@PathVariable int section_id){
        RespnseMessage message=courseSectionService.deleteCourseSection(section_id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PutMapping("/courses/sections/{section_id}")
    public ResponseEntity <RespnseMessage> updateSection(@PathVariable int section_id,@RequestBody CourseSection request){
        RespnseMessage message=courseSectionService.updateCourseSection(section_id,request);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
