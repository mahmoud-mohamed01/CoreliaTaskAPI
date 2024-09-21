package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import com.example.OnlineLearningSystem.model.Quiz;
import com.example.OnlineLearningSystem.model.StudentSubmission;
import com.example.OnlineLearningSystem.model.User;
import com.example.OnlineLearningSystem.repository.QuizRepository;
import com.example.OnlineLearningSystem.repository.StudentSubmissionRepository;
import com.example.OnlineLearningSystem.repository.UserRepository;
import com.example.OnlineLearningSystem.service.StudentSubmissionService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentSubmissionServiceImpl implements StudentSubmissionService {
    private StudentSubmissionRepository studentSubmissionRepository;
    private UserRepository userRepository;
    private QuizRepository quizRepository;
    @Override
    public RespnseMessage submitAnswers(StudentSubmission request,String studentId, String quizId) {
        User student=userRepository.findById(Integer.parseInt(studentId))
                .orElseThrow(()->new NotFoundException());
        Quiz quiz=quizRepository.findById(Integer.parseInt(quizId))
                .orElseThrow(()->new NotFoundException());

        StudentSubmission studentSubmission=new StudentSubmission();
        studentSubmission.setStudent(student);
        studentSubmission.setQuiz(quiz);
        studentSubmission.setScore(request.getScore());
        studentSubmissionRepository.save(studentSubmission);
        return new RespnseMessage("answers Submitted");
    }
}
