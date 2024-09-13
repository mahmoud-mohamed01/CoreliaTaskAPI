package com.example.OnlineLearningSystem.repository;

import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.CourseSection;
import com.example.OnlineLearningSystem.model.Lesson;
import com.example.OnlineLearningSystem.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz,Integer> {
    List<Quiz> findByCourse(Course course);

}
