package com.sas.SalesAnalysisSystem.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sas.SalesAnalysisSystem.model.Sales;

public interface SalesRepository extends JpaRepository<Sales, Long> {
	
	@Query
	List<Sales> findByInvoice_Products_ProductName(String productName);
    List<Sales> findByInvoice_Distributor_State(String state);
    Sales findByInvoice_InvoiceNumber(long invoiceNumber);
}