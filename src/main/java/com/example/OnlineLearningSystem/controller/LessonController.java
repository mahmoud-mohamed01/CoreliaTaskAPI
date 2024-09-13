package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.CourseSection;
import com.example.OnlineLearningSystem.model.Lesson;
import com.example.OnlineLearningSystem.service.CourseSectionService;
import com.example.OnlineLearningSystem.service.LessonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LessonController {
        private LessonService lessonService;


        @PostMapping("/courses/sections/lessons")
        public ResponseEntity<RespnseMessage> createLesson(@RequestBody Lesson request, @RequestParam String section_id ){
            RespnseMessage message=lessonService.createLesson( request,section_id);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }

        @GetMapping("/courses/sections/lessons")
        public ResponseEntity<List<Lesson>> getAllLessonsBySection(@RequestParam String section_id){
            List<Lesson> lessons=lessonService.getLessons(section_id);
            return new ResponseEntity<>(lessons,HttpStatus.OK);
        }

        @GetMapping("/courses/sections/lessons/{lesson_id}")
        public ResponseEntity<Lesson> getlesson(@PathVariable int lesson_id ){
            Lesson lesson=lessonService.getLesson(lesson_id);
            return new ResponseEntity<>(lesson,HttpStatus.OK);

        }

        @DeleteMapping("/courses/sections/lessons/{lesson_id}")
        public ResponseEntity <RespnseMessage> deleteLesson(@PathVariable int lesson_id){
            RespnseMessage message=lessonService.deleteLesson(lesson_id);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }

        @PutMapping("/courses/sections/lessons/{lesson_id}")
        public ResponseEntity <RespnseMessage> updateLesson(@PathVariable int lesson_id,@RequestBody Lesson request){
            RespnseMessage message=lessonService.updateLesson(lesson_id,request);
            return new ResponseEntity<>(message,HttpStatus.OK);
        }
}
