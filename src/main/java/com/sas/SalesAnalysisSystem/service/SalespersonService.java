package com.sas.SalesAnalysisSystem.service;

import com.sas.SalesAnalysisSystem.model.Salesperson;

import java.util.List;

public interface SalespersonService {
    Salesperson createSalesperson(Salesperson salesperson);

    Salesperson updateSalesperson(Integer id, Salesperson salesperson);

    List<Salesperson> getAllSalespersons();

    Salesperson getSalespersonById(Integer salespersonId);

    void deleteSalesperson(Integer salespersonId);
}
