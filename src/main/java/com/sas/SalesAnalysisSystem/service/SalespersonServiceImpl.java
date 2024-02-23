package com.sas.SalesAnalysisSystem.service;

import com.sas.SalesAnalysisSystem.exception.ResourceNotFoundException;
import com.sas.SalesAnalysisSystem.model.Category;
import com.sas.SalesAnalysisSystem.model.Salesperson;
import com.sas.SalesAnalysisSystem.repository.DistributorRepository;
import com.sas.SalesAnalysisSystem.repository.SalespersonRepository;

import io.micrometer.common.util.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalespersonServiceImpl implements SalespersonService {

    private final SalespersonRepository salespersonRepository;
    private final DistributorRepository distributorRepository;

    @Autowired
    public SalespersonServiceImpl(SalespersonRepository salespersonRepository,DistributorRepository distributorRepository) {
        this.salespersonRepository = salespersonRepository;
        this.distributorRepository=distributorRepository;
    }

    @Override
    public Salesperson createSalesperson(Salesperson salesperson) {
        return salespersonRepository.save(salesperson);
    }

    @Override
    public Salesperson updateSalesperson(Integer id, Salesperson salesperson) {
        Optional<Salesperson> salespersonDb = salespersonRepository.findById(id);
        if (salespersonDb.isPresent()) {
            Salesperson salespersonUpdate = salespersonDb.get();
            salespersonUpdate.setName(salesperson.getName());
            salespersonUpdate.setContactNumber(salesperson.getContactNumber());
            salespersonUpdate.setEmail(salesperson.getEmail());
            return salespersonRepository.save(salespersonUpdate);
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + id);
        }
    }

    @Override
    public List<Salesperson> getAllSalespersons() {
        List<Salesperson> salespersons = salespersonRepository.findAll();
        if (salespersons.isEmpty()) {
            throw new ResourceNotFoundException("No Salespersons found");
        }
        return salespersons;
    }

    @Override
    public Salesperson getSalespersonById(Integer salespersonId) {
        Optional<Salesperson> salespersonDb = salespersonRepository.findById(salespersonId);
        if (salespersonDb.isEmpty()) {
            throw new ResourceNotFoundException("Record not found with id: " + salespersonId);
        }
        return salespersonDb.get();
    }

    @Override
    public void deleteSalesperson(Integer salespersonId) {
        Optional<Salesperson> salespersonDb = salespersonRepository.findById(salespersonId);
        if (salespersonDb.isPresent()) {
            salespersonRepository.delete(salespersonDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id: " + salespersonId);
        }
    }


    
}

