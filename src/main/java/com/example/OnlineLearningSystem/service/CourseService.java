package com.example.OnlineLearningSystem.service;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.CourseCategory;

import java.util.List;

public interface CourseService {
    RespnseMessage createCourse(Course course,String instructor_id,String category_id);
    List<Course> getCourses();
    Course getCourse(int id);
    RespnseMessage updateCourse(int id,Course course,String instructor_id,String category_id);
    RespnseMessage deleteCourse(int id,String instructor_id);
}
