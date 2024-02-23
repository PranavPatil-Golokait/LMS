package com.sas.SalesAnalysisSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.SalesAnalysisSystem.model.Salesperson;

public interface SalespersonRepository extends JpaRepository<Salesperson, Integer> {

}
