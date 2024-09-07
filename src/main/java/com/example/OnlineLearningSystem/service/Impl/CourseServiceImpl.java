package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.service.CourseService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    @Override
    public RespnseMessage createCourse(Course course) {
        return null;
    }

    @Override
    public List<Course> getCourses() {
        return List.of();
    }

    @Override
    public Course getCourse(int id) {
        return null;
    }

    @Override
    public RespnseMessage updateCourse(int id, Course course) {
        return null;
    }

    @Override
    public RespnseMessage deleteCourse(int id) {
        return null;
    }
}
