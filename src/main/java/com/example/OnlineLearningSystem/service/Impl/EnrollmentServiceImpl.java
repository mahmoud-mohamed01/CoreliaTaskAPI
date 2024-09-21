package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import com.example.OnlineLearningSystem.model.Course;
import com.example.OnlineLearningSystem.model.Enrollment;
import com.example.OnlineLearningSystem.model.Quiz;
import com.example.OnlineLearningSystem.model.User;
import com.example.OnlineLearningSystem.repository.CourseRepository;
import com.example.OnlineLearningSystem.repository.EnrollmentRepository;
import com.example.OnlineLearningSystem.repository.UserRepository;
import com.example.OnlineLearningSystem.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private EnrollmentRepository enrollmentRepository;
    private UserRepository userRepository;
    private CourseRepository courseRepository;


    @Override
    public RespnseMessage enrollStudentToCourse(String studentId, String courseId) {
        User student=userRepository.findById(Integer.parseInt(studentId))
                .orElseThrow(()->new NotFoundException());
        Course course=courseRepository.findById(Integer.parseInt(courseId))
                .orElseThrow(()->new NotFoundException());
        Enrollment enrollment=new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollmentRepository.save(enrollment);
        return new RespnseMessage("Student enrolled to course with id:"+courseId);
    }

    @Override
    public List<Enrollment> getStudentCourses(String studentId) {
        User student=userRepository.findById(Integer.parseInt(studentId))
                .orElseThrow(()->new NotFoundException());
        return enrollmentRepository.findByStudent(student);
    }

}
