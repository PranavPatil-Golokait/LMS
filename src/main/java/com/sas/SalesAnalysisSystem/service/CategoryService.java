package com.sas.SalesAnalysisSystem.service;

import java.util.List;

import com.sas.SalesAnalysisSystem.model.Category;

public interface CategoryService {

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategories();

    void deleteCategory(long categoryId);

    Category updateCategory(Category category);

    Category createCategory(Category category);
}

