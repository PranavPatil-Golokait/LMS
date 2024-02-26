package com.sas.SalesAnalysisSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.SalesAnalysisSystem.model.Salesperson;


public interface SalespersonRepository extends JpaRepository<Salesperson, Long> {
    List<Salesperson> findAllByIdIn(List<Long> salespersonIds);
}
