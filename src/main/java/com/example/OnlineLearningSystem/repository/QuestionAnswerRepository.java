package com.example.OnlineLearningSystem.repository;

import com.example.OnlineLearningSystem.model.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswer,Integer> {
}
