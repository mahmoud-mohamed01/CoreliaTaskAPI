package com.example.OnlineLearningSystem.repository;

import com.example.OnlineLearningSystem.model.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizQuestionRepostiory extends JpaRepository<QuizQuestion,Integer> {
}
