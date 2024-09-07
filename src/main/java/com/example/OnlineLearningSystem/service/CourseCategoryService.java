package com.example.OnlineLearningSystem.service;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.CourseCategory;

import java.util.List;

public interface CourseCategoryService {

    RespnseMessage createCategory(CourseCategory courseCategory);
    List<CourseCategory> getCategories();
    CourseCategory getCategory(int id);
    RespnseMessage updateCategory(int id,CourseCategory category);
    RespnseMessage deleteCategory(int id);
}
