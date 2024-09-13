package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import com.example.OnlineLearningSystem.model.CourseSection;
import com.example.OnlineLearningSystem.model.Lesson;
import com.example.OnlineLearningSystem.repository.CourseSectionRepository;
import com.example.OnlineLearningSystem.repository.LessonRepository;
import com.example.OnlineLearningSystem.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LessonServiceImpl implements LessonService {
    private LessonRepository lessonRepository;
    private CourseSectionRepository courseSectionRepository;


    @Override
    public RespnseMessage createLesson(Lesson request, String section_id) {
        Lesson lesson =new Lesson();
        CourseSection section=courseSectionRepository.findById(Integer.parseInt(section_id))
                .orElseThrow(()->new NotFoundException("no section with this id:"+section_id));
        lesson.setLessonNumber(request.getLessonNumber());
        lesson.setLessonName(request.getLessonName());
        lesson.setVideoUrl(request.getVideoUrl());
        lesson.setResoursesUrl(request.getResoursesUrl());
        lesson.setSection(section);

        return new RespnseMessage("lesson created");
    }

    @Override
    public List<Lesson> getLessons(String section_id) {
        CourseSection section=courseSectionRepository.findById(Integer.parseInt(section_id))
                .orElseThrow(()->new NotFoundException("no section with this id:"+section_id));
       List<Lesson> lessons=lessonRepository.findBysection(section);
        return lessons;
    }

    @Override
    public Lesson getLesson(int id) {
        return lessonRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no lesson with this id:"+id));
    }

    @Override
    public RespnseMessage updateLesson(int id, Lesson request) {
        Lesson lesson=lessonRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no lesson with this id:"+id));
        lesson.setLessonNumber(request.getLessonNumber()!=0? request.getLessonNumber() : lesson.getLessonNumber() );
        lesson.setLessonName(request.getLessonName()!=null? request.getLessonName() : lesson.getLessonName() );
        lesson.setResoursesUrl(request.getResoursesUrl()!=null? request.getResoursesUrl() : lesson.getResoursesUrl() );
        lesson.setVideoUrl(request.getVideoUrl()!=null? request.getVideoUrl() : lesson.getVideoUrl() );

        return new RespnseMessage("lesson updated");
    }

    @Override
    public RespnseMessage deleteLesson(int id) {
         lessonRepository.deleteById(id);
         return new RespnseMessage("lesson deleted");
    }
}
