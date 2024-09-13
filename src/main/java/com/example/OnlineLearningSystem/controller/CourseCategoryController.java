package com.example.OnlineLearningSystem.controller;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.CourseCategory;
import com.example.OnlineLearningSystem.service.CourseCategoryService;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CourseCategoryController{
    private CourseCategoryService courseCategoryService;

    @PostMapping("/admin/categories")
    public ResponseEntity<RespnseMessage> createCategory(@RequestBody CourseCategory category){
        RespnseMessage message=courseCategoryService.createCategory(category);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/public/categories")
    public ResponseEntity<List<CourseCategory>> getCategories(){
        List<CourseCategory> categories=courseCategoryService.getCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

    @GetMapping("/public/categories/{id}")
    public ResponseEntity<CourseCategory> getCategory(@PathVariable int id ){
        System.out.println("id: "+id);
        CourseCategory category=courseCategoryService.getCategory(id);
        return new ResponseEntity<>(category,HttpStatus.OK);

    }

    @DeleteMapping("/admin/categories/{id}")
    public ResponseEntity <RespnseMessage> deleteCategory(@PathVariable int id){
        RespnseMessage message=courseCategoryService.deleteCategory(id);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @PutMapping("/admin/categories/{id}")
    public ResponseEntity <RespnseMessage> updateCategory(@PathVariable int id,@RequestBody CourseCategory category){
        RespnseMessage message=courseCategoryService.updateCategory(id,category);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }




}
