package com.sas.SalesAnalysisSystem.service;

import java.time.LocalDate;
import java.util.List;

import com.sas.SalesAnalysisSystem.model.Invoice;

public interface InvoiceService {
	
	Invoice createInvoice(Invoice invoice);
	Invoice getInvoiceByInvoiceNumber(Long invoice_number);
	List<Invoice> getInvoiceByDate(LocalDate inv_date);
	List<Invoice> getAllInvoices();
	Invoice updateInvoice(Invoice updatedInvoice);
	void deleteInvoice(Long invoice_number);
}