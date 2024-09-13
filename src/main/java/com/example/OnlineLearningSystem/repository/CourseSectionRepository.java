package com.example.OnlineLearningSystem.repository;

import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.CourseSection;
import com.example.OnlineLearningSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseSectionRepository extends JpaRepository<CourseSection,Integer> {
    List<CourseSection> findByCourse(Course course);

}
