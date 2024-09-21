package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.CourseSection;
import com.example.OnlineLearningSystem.repository.CourseRepository;
import com.example.OnlineLearningSystem.repository.CourseSectionRepository;
import com.example.OnlineLearningSystem.service.CourseSectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseSectionServiceImp implements CourseSectionService {
    CourseSectionRepository courseSectionRepository;
    CourseRepository courseRepository;
    @Override
    public RespnseMessage createCourseSection(CourseSection request, int course_id) {
        CourseSection courseSection=new CourseSection();
        Course course =courseRepository.findById(course_id)
                .orElseThrow(()->new NotFoundException("no course with this id:"+course_id ));

        courseSection.setSectionName(request.getSectionName());
        courseSection.setSectionNumber(request.getSectionNumber());
        courseSection.setCourse(course);
        courseSectionRepository.save(courseSection);
        return new RespnseMessage("Course section created successfully");
    }

    @Override
    public List<CourseSection> getCourseSectionbyCourse(int course_id) {
        Course course =courseRepository.findById(course_id)
                .orElseThrow(()->new NotFoundException("no course with this id:"+course_id ));
        return courseSectionRepository.findByCourse(course);
    }

    @Override
    public CourseSection getCourseSection(int id) {
        return courseSectionRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no section with this id:"+id));
    }

    @Override
    public RespnseMessage updateCourseSection(int id, CourseSection request) {
       CourseSection courseSection= courseSectionRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no section with this id:"+id));

       courseSection.setSectionName(request.getSectionName()!=null?request.getSectionName():courseSection.getSectionName());
       courseSection.setSectionNumber(request.getSectionNumber()!=0?request.getSectionNumber():courseSection.getSectionNumber());
       courseSectionRepository.save(courseSection);
        return  new RespnseMessage("section updated");
    }

    @Override
    public RespnseMessage deleteCourseSection(int id) {
         courseSectionRepository.deleteById(id);
         return new RespnseMessage("section deleted");
    }
}
