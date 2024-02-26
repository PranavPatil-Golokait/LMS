package com.sas.SalesAnalysisSystem.service;

import com.sas.SalesAnalysisSystem.model.Salesperson;

import java.util.List;

public interface SalespersonService {
    Salesperson createSalesperson(Salesperson salesperson);

    Salesperson updateSalesperson(Long id, Salesperson salesperson);

    List<Salesperson> getAllSalespersons();

    Salesperson getSalespersonById(Long salespersonId);

    void deleteSalesperson(Long salespersonId);
}
