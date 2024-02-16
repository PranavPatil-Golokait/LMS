package com.sas.SalesAnalysisSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sas.SalesAnalysisSystem.model.Category;
import com.sas.SalesAnalysisSystem.service.CategoryService;

@RestController
@RequestMapping("/home")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok().body(categoryService.getAllCategories());
    }

    @PostMapping("/addcategories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
    	System.out.println(category);
        Category createdCategory = categoryService.createCategory(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }
    @PutMapping("/categories/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        category.setId(id);
        return ResponseEntity.ok().body(this.categoryService.updateCategory(category));
    }

    @DeleteMapping("/categories/{id}")
    public HttpStatus deleteCategory(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
        return HttpStatus.OK;
    }
}
