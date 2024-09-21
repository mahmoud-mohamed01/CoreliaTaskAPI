package com.example.OnlineLearningSystem.service;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.StudentSubmission;

public interface StudentSubmissionService {
    RespnseMessage submitAnswers(StudentSubmission request, String studentId, String quizId);
}
