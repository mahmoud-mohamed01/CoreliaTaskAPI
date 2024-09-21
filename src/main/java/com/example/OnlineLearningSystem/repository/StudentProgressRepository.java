package com.example.OnlineLearningSystem.repository;

import com.example.OnlineLearningSystem.model.StudentProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProgressRepository extends JpaRepository<StudentProgress,Integer> {
}
