package com.example.OnlineLearningSystem.service;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.CourseCategory;

import java.util.List;

public interface CourseService {
    RespnseMessage createCourse(Course course);
    List<Course> getCourses();
    Course getCourse(int id);
    RespnseMessage updateCourse(int id,Course course);
    RespnseMessage deleteCourse(int id);
}
