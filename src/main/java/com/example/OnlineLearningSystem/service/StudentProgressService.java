package com.example.OnlineLearningSystem.service;

import com.example.OnlineLearningSystem.dto.RespnseMessage;

public interface StudentProgressService {

     RespnseMessage checkLessonToComplete(String student_id,String lesson_id);
}
