package com.sas.SalesAnalysisSystem.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sas.SalesAnalysisSystem.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	Optional<List<Invoice>> findByInvDate(LocalDate invDate);
}