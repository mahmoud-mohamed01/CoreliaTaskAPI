package com.example.OnlineLearningSystem.repository;

import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.CourseSection;
import com.example.OnlineLearningSystem.model.Enrollment;
import com.example.OnlineLearningSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment,Integer> {
    List<Enrollment> findByStudent(User student);

}
