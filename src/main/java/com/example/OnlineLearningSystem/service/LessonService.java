package com.example.OnlineLearningSystem.service;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.Lesson;

import java.util.List;

public interface LessonService {
    RespnseMessage createLesson(Lesson request, String section_id);
    List<Lesson> getLessons(String section_id);
    Lesson getLesson(int id);
    RespnseMessage updateLesson(int id,Lesson request);
    RespnseMessage deleteLesson(int id);
}
