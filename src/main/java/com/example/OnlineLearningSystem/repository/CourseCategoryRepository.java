package com.example.OnlineLearningSystem.repository;

import com.example.OnlineLearningSystem.model.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseCategoryRepository extends JpaRepository<CourseCategory,Integer> {
}
