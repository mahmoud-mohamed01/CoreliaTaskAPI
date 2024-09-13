package com.example.OnlineLearningSystem.service;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Quiz;
import com.example.OnlineLearningSystem.model.QuizQuestion;

public interface QuizQuestionService {

    RespnseMessage createQuestion(QuizQuestion request,String quizId);
    RespnseMessage deleteQuestion(int id);

}
