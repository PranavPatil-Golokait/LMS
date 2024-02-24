package com.sas.SalesAnalysisSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sas.SalesAnalysisSystem.model.Sales;
import com.sas.SalesAnalysisSystem.repository.InvoiceRepository;
import com.sas.SalesAnalysisSystem.repository.SalesRepository;

import java.util.List;

@RestController
@RequestMapping("api/v1/sales")
public class SalesController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private SalesRepository salesRepository;

    // Endpoint to get sales by product
    @GetMapping("/by-product")
    
    public List<Sales> getSalesByProduct(@RequestParam String productName) {
        // Implement a method in the repository to fetch sales by product
        return salesRepository.findByInvoice_Products_ProductName(productName);
    }

    // Endpoint to get sales by region (assuming distributor's state represents region)
    @GetMapping("/by-region")
    public List<Sales> getSalesByRegion(@RequestParam String region) {
        // Implement a method in the repository to fetch sales by region
        return salesRepository.findByInvoice_Distributor_State(region);
    }

    // Endpoint to get sales by invoice number
    
    @GetMapping("/by-invoice")
    public Sales getSalesByInvoice(@RequestParam long invoiceNumber) {
        // Implement a method in the repository to fetch sales by invoice number
        return salesRepository.findByInvoice_InvoiceNumber(invoiceNumber);
    }
}
