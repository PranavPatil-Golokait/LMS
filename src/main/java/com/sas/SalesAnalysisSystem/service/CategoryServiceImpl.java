package com.sas.SalesAnalysisSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.SalesAnalysisSystem.exception.ResourceNotFoundException;
import com.sas.SalesAnalysisSystem.model.Category;
import com.sas.SalesAnalysisSystem.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> categoryDb = categoryRepository.findById(category.getId());
        if (categoryDb.isPresent()) {
            Category categoryUpdate = categoryDb.get();
            categoryUpdate.setName(category.getName());
            categoryUpdate.setActive(category.getActive());
            return categoryRepository.save(categoryUpdate);
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + category.getId());
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        Optional<Category> categoryDb = categoryRepository.findById(categoryId);
        return categoryDb.orElseThrow(() -> new ResourceNotFoundException("Record not found with id: " + categoryId));
    }

    @Override
    public void deleteCategory(long categoryId) {
        Optional<Category> categoryDb = categoryRepository.findById(categoryId);
        categoryDb.ifPresentOrElse(
            category -> categoryRepository.delete(category),
            () -> {
                throw new ResourceNotFoundException("Record not found with id: " + categoryId);
            }
        );
    }
}
