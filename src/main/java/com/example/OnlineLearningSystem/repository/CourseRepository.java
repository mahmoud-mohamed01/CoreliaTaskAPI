package com.example.OnlineLearningSystem.repository;

import com.example.OnlineLearningSystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
