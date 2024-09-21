package com.example.OnlineLearningSystem.service;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.QuestionAnswer;

public interface QuestionAnswerService {

    RespnseMessage createAnswer(QuestionAnswer request, String questionId);
    RespnseMessage deleteAnswer (int id);

}
