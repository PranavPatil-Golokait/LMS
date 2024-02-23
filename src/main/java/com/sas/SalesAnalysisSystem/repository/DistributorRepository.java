package com.sas.SalesAnalysisSystem.repository;

import com.sas.SalesAnalysisSystem.model.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

}
