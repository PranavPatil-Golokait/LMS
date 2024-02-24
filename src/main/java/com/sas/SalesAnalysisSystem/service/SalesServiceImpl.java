package com.sas.SalesAnalysisSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.SalesAnalysisSystem.model.Sales;
import com.sas.SalesAnalysisSystem.repository.SalesRepository;

import java.util.List;

@Service
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    
    @Autowired
    public SalesServiceImpl(SalesRepository salesRepository) {
    	
        this.salesRepository = salesRepository;
    }

    @Override
	public List<Sales> getSalesByProduct(String productName) {
        return salesRepository.findByInvoice_Products_ProductName(productName);
    }

    @Override
    public List<Sales> getSalesByRegion(String state) {
        return salesRepository.findByInvoice_Distributor_State(state);
    }

    @Override
    public Sales getSalesByInvoiceNumber(long invoiceNumber) {
        return salesRepository.findByInvoice_InvoiceNumber(invoiceNumber);
    }
}
