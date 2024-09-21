package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.BadRequestException;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.CourseCategory;
import com.example.OnlineLearningSystem.model.User;
import com.example.OnlineLearningSystem.repository.CourseCategoryRepository;
import com.example.OnlineLearningSystem.repository.CourseRepository;
import com.example.OnlineLearningSystem.repository.UserRepository;
import com.example.OnlineLearningSystem.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private UserRepository userRepository;
    private CourseCategoryRepository courseCategoryRepository;

    @Override
    public RespnseMessage createCourse(Course request,String instructor_id,String category_id) {
        Course course=new Course();
        course.setName(request.getName());
        course.setPrice(request.getPrice());
        course.setDescription(request.getDescription());
        //adding instructor to the course
        User instructor= userRepository.findById(Integer.parseInt(instructor_id))
                .orElseThrow(()->new NotFoundException("no instructor with id:"+instructor_id));
        course.setInstructor(instructor);
        //adding category to the course
        CourseCategory category= courseCategoryRepository.findById(Integer.parseInt(category_id))
                .orElseThrow(()->new NotFoundException("no category with id:"+category_id));
        course.setCourseCategory(category);
        courseRepository.save(course);
        return new RespnseMessage("course created successfully");
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(int id) {
        return courseRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no course with this id:"+id));
    }

    @Override
    public RespnseMessage updateCourse(int id, Course request,String instructor_id,String category_id) {
        Course course =courseRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no course with this id:"+id ));
        CourseCategory category=new CourseCategory();

        //check that instructor id is the same
        if(instructor_id!=null && course.getInstructor().getId()!=Integer.parseInt(instructor_id)){
                throw new BadRequestException("not matching instructor id");
        }

        if (category_id!=null){
            category=courseCategoryRepository.findById(Integer.parseInt(category_id))
                    .orElseThrow(()->new NotFoundException("no category with id:"+category_id));
        }
        course.setName(request.getName()!=null? request.getName():course.getName());
        course.setDescription(request.getDescription()!=null? request.getDescription():course.getDescription());
        course.setPrice(request.getPrice()!=0? request.getPrice():course.getPrice());
        course.setCourseCategory(category_id!=null? category:course.getCourseCategory());
        courseRepository.save(course);
        return new RespnseMessage("course updated successfully");
    }

    @Override
    public RespnseMessage deleteCourse(int id,String instructor_id) {
        Course course=courseRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no course with this id:"+id));
        if(course.getInstructor().getId()!=Integer.parseInt(instructor_id)){
            throw new BadRequestException("not matching instructor id");
        }
        courseRepository.delete(course);
        return new RespnseMessage("course deleted successfully");
    }
}
