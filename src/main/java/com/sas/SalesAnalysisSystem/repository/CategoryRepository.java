package com.sas.SalesAnalysisSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.SalesAnalysisSystem.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
