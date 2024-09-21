package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import com.example.OnlineLearningSystem.model.Lesson;
import com.example.OnlineLearningSystem.model.StudentProgress;
import com.example.OnlineLearningSystem.model.User;
import com.example.OnlineLearningSystem.repository.LessonRepository;
import com.example.OnlineLearningSystem.repository.StudentProgressRepository;
import com.example.OnlineLearningSystem.repository.UserRepository;
import com.example.OnlineLearningSystem.service.StudentProgressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentProgressServiceImp implements StudentProgressService {
    private StudentProgressRepository studentProgressRepository;
    private UserRepository userRepository;
    private LessonRepository lessonRepository;
    @Override
    public RespnseMessage checkLessonToComplete(String student_id, String lesson_id) {
        User student= userRepository.findById(Integer.parseInt(student_id))
                .orElseThrow(()->new NotFoundException());
        Lesson lesson=lessonRepository.findById(Integer.parseInt(lesson_id))
                .orElseThrow(()->new NotFoundException());

        StudentProgress studentProgress=new StudentProgress();
        studentProgress.setLessonId(lesson);
        studentProgress.setStudentId(student);
        studentProgressRepository.save(studentProgress);
        return new RespnseMessage("progress saved");
    }
}
