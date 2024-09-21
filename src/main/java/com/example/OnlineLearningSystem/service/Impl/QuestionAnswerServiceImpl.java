package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import com.example.OnlineLearningSystem.model.QuestionAnswer;
import com.example.OnlineLearningSystem.model.QuizQuestion;
import com.example.OnlineLearningSystem.repository.QuestionAnswerRepository;
import com.example.OnlineLearningSystem.repository.QuizQuestionRepostiory;
import com.example.OnlineLearningSystem.service.QuestionAnswerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
    private QuestionAnswerRepository questionAnswerRepository;
    private QuizQuestionRepostiory quizQuestionRepostiory;


    @Override
    public RespnseMessage createAnswer(QuestionAnswer request,String questionId) {
        QuizQuestion question=quizQuestionRepostiory.findById(Integer.parseInt(questionId))
                .orElseThrow(()->new NotFoundException());
        QuestionAnswer answer=new QuestionAnswer();
        answer.setQuestion(question);
        answer.setCorrect(request.isCorrect());
        answer.setAnswer(request.getAnswer());
        questionAnswerRepository.save(answer);
        return new RespnseMessage("answer added for this question with id:"+ questionId);
    }

    @Override
    public RespnseMessage deleteAnswer(int id) {
        questionAnswerRepository.deleteById(id);
        return new RespnseMessage("answer deleted");
    }
}
