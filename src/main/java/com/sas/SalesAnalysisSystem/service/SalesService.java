package com.sas.SalesAnalysisSystem.service;

import java.util.List;

import com.sas.SalesAnalysisSystem.model.Sales;

public interface SalesService {

    List<Sales> getSalesByProduct(String productName);

    List<Sales> getSalesByRegion(String state);

    Sales getSalesByInvoiceNumber(long invoiceNumber);
}
