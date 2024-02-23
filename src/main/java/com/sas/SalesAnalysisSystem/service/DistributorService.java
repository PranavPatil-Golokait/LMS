package com.sas.SalesAnalysisSystem.service;

import com.sas.SalesAnalysisSystem.model.Distributor;
import com.sas.SalesAnalysisSystem.model.Product;
import com.sas.SalesAnalysisSystem.model.Salesperson;

import java.util.List;

public interface DistributorService {

    Distributor createDistributor(Distributor distributor);

    Distributor updateDistributor(Integer id, Distributor distributor);

    List<Distributor> getAllDistributors();

    void deleteDistributor(int id);

	Distributor getDistributorById(Integer id);

	List<Product> getAllProducts(Integer id);

	List<Salesperson> getAllSalesperson(Integer id);

}
