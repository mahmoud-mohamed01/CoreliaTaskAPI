package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import com.example.OnlineLearningSystem.model.Quiz;
import com.example.OnlineLearningSystem.model.QuizQuestion;
import com.example.OnlineLearningSystem.repository.QuizQuestionRepostiory;
import com.example.OnlineLearningSystem.repository.QuizRepository;
import com.example.OnlineLearningSystem.service.QuizQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuizQuestionServiceImp implements QuizQuestionService {

    private QuizQuestionRepostiory quizQuestionRepostiory;
    private QuizRepository quizRepository;
    @Override
    public RespnseMessage createQuestion(QuizQuestion request,String quizId) {
        Quiz quiz=quizRepository.findById(Integer.parseInt(quizId))
                .orElseThrow(()->new NotFoundException());
        QuizQuestion question=new QuizQuestion();
        question.setQuestion(request.getQuestion());
        question.setQuiz(quiz);
        quizQuestionRepostiory.save(question);
        return new RespnseMessage("question added");
    }

    @Override
    public RespnseMessage deleteQuestion(int id) {
        quizQuestionRepostiory.deleteById(id);
        return new RespnseMessage("question deleted");
    }
}
