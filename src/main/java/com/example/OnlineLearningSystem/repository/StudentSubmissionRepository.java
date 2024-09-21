package com.example.OnlineLearningSystem.repository;

import com.example.OnlineLearningSystem.model.StudentSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSubmissionRepository extends JpaRepository<StudentSubmission,Integer> {
}
