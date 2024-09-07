package com.example.OnlineLearningSystem.service.Impl;

import com.example.OnlineLearningSystem.dto.RespnseMessage;
import com.example.OnlineLearningSystem.exception.NotFoundException;
import com.example.OnlineLearningSystem.model.CourseCategory;
import com.example.OnlineLearningSystem.repository.CourseCategoryRepository;
import com.example.OnlineLearningSystem.service.CourseCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CourseCategoryServiceImpl implements CourseCategoryService {
    CourseCategoryRepository courseCategoryRepository;

    @Override
    public RespnseMessage createCategory(CourseCategory courseCategory) {
        CourseCategory category=new CourseCategory();
        category.setCategoryName(courseCategory.getCategoryName());
        courseCategoryRepository.save(category);
        return new RespnseMessage("category created successfully") ;

    }

    @Override
    public List<CourseCategory> getCategories() {
        return courseCategoryRepository.findAll();
    }

    @Override
    public CourseCategory getCategory(int id) {
        return courseCategoryRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no category with this id :"+id));
    }

    @Override
    public RespnseMessage updateCategory(int id, CourseCategory courseCategory) {
        CourseCategory category=courseCategoryRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no category with this id :"+id));
        category.setCategoryName(courseCategory.getCategoryName());
        courseCategoryRepository.save(category);
        return new RespnseMessage("category updated successfully") ;
    }

    @Override
    public RespnseMessage deleteCategory(int id) {
        CourseCategory category=courseCategoryRepository.findById(id)
                .orElseThrow(()->new NotFoundException("no category with this id :"+id));
        courseCategoryRepository.delete(category);
        return new RespnseMessage("category deleted successfully ");
    }
}
