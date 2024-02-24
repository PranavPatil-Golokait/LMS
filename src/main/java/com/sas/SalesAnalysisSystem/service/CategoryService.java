package com.sas.SalesAnalysisSystem.service;

import java.util.List;

import com.sas.SalesAnalysisSystem.model.Category;

public interface CategoryService {

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategories();

    void deleteCategory(Long categoryId);

    Category createCategory(Category category);

	Category updateCategory(Long id, Category category);
}

