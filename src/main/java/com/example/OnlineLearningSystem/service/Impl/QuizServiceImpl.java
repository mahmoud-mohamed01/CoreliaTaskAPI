package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.Lesson;
import com.example.OnlineLearningSystem.model.Quiz;
import com.example.OnlineLearningSystem.repository.CourseRepository;
import com.example.OnlineLearningSystem.repository.QuizRepository;
import com.example.OnlineLearningSystem.service.QuizService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuizServiceImpl implements QuizService {
    private CourseRepository courseRepository;
    private QuizRepository quizRepository;
    @Override
    public RespnseMessage createQuiz(Quiz request, String courseId) {
        Quiz quiz=new Quiz();
        Course course =courseRepository.findById(Integer.parseInt(courseId))
                .orElseThrow(()->new NotFoundException("no course with this id:"+courseId));
        quiz.setName(request.getName());
        quiz.setNumber(request.getNumber());
        quiz.setMinScore(request.getMinScore());
        quiz.setCourse(course);
        quizRepository.save(quiz);
        return new RespnseMessage("quiz created for course with id:"+courseId);
    }

    @Override
    public List<Quiz> getQuizByCourseID(String courseId) {
        Course course=courseRepository.findById(Integer.parseInt(courseId))
                .orElseThrow(()->new NotFoundException("no course with this id:"+courseId));
        List<Quiz> quizzes =quizRepository.findByCourse(course);
        return quizzes;
    }

    @Override
    public Quiz getQuiz(int id) {
        return quizRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no quiz this id:"+ id)) ;
    }

    @Override
    public RespnseMessage updateQuiz(int id, Quiz request) {
        Quiz quiz=quizRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no quiz this id:"+ id));
        quiz.setName(request.getName()!=null?request.getName(): quiz.getName());
        quiz.setNumber(request.getNumber()!=0?request.getNumber(): quiz.getNumber());
        quiz.setMinScore(request.getMinScore()!=0?request.getMinScore(): quiz.getMinScore());
        quizRepository.save(quiz);
        return new RespnseMessage("quiz updated");
    }

    @Override
    public RespnseMessage deleteQuiz(int id) {
        quizRepository.deleteById(id);
        return new RespnseMessage("quiz deleted");
    }
}
