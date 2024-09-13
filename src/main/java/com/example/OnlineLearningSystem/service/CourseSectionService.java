package com.example.OnlineLearningSystem.service;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.CourseSection;

import java.util.List;

public interface CourseSectionService {
    RespnseMessage createCourseSection(CourseSection request,int course_id);
    List<CourseSection> getCourseSectionbyCourse(int Course_id);
    CourseSection getCourseSection(int id);
    RespnseMessage updateCourseSection(int id,CourseSection request);
    RespnseMessage deleteCourseSection(int id);

}
