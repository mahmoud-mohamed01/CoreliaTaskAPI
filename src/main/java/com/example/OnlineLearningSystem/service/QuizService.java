package com.example.OnlineLearningSystem.service;


import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Lesson;
import com.example.OnlineLearningSystem.model.Quiz;

import java.util.List;

public interface QuizService {
    RespnseMessage createQuiz(Quiz request, String courseId);
    List<Quiz> getQuizByCourseID(String courseId);
    Quiz getQuiz (int id);
    RespnseMessage updateQuiz(int id,Quiz request);
    RespnseMessage deleteQuiz(int id);

}
