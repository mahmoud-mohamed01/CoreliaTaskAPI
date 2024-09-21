package com.example.OnlineLearningSystem.service;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Enrollment;

import java.util.Date;
import java.util.List;

public interface EnrollmentService {
    RespnseMessage enrollStudentToCourse(String studentId, String courseId);
    List<Enrollment> getStudentCourses (String student_id);
}
