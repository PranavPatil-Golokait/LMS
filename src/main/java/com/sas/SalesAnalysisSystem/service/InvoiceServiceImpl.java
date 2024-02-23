package com.sas.SalesAnalysisSystem.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sas.SalesAnalysisSystem.exception.ResourceNotFoundException;
import com.sas.SalesAnalysisSystem.model.Invoice;
import com.sas.SalesAnalysisSystem.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	private final InvoiceRepository invoiceRepository;
	
	@Autowired
	public InvoiceServiceImpl(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

	@Override
	public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
	}
	
	@Override
	public List<Invoice> getInvoiceByDate(LocalDate inv_date) {
	    Optional<List<Invoice>> invoices = invoiceRepository.findByInvDate(inv_date);
	    
	    if (invoices.isPresent()) {
	        return invoices.get();
	    } else {
	        throw new ResourceNotFoundException("No invoices found with date: " + inv_date);
	    }
	}

	@Override
	public Invoice getInvoiceByInvoiceNumber(Long invoice_number) {
	    Optional<Invoice> invoice = invoiceRepository.findById(invoice_number);
	    
	    if (invoice.isPresent()) {
	        return invoice.get();
	    } else {
	        throw new ResourceNotFoundException("No invoice found with Invoice Number: " + invoice_number);
	    }
	}

	
	@Override
	public List<Invoice> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        if (invoices.isEmpty()) {
            throw new ResourceNotFoundException("No invoices found");
        }
        return invoices;
    }
	
	@Override
    public Invoice updateInvoice(Invoice updatedInvoice) {
        Optional<Invoice> existingInvoice = invoiceRepository.findById(updatedInvoice.getInvoice_number());
        if (existingInvoice.isPresent()) {
            Invoice invoiceUpdate = existingInvoice.get();
            invoiceUpdate.setInvoice_number(updatedInvoice.getInvoice_number());
            invoiceUpdate.setInvDate(updatedInvoice.getInvDate());
            invoiceUpdate.setNetAmount(updatedInvoice.getNetAmount());
            invoiceUpdate.setCgst(updatedInvoice.getCgst());
            invoiceUpdate.setSgst(updatedInvoice.getSgst());
            invoiceUpdate.setTotalAmount(updatedInvoice.getTotalAmount());
            invoiceUpdate.setPurchaseNumber(updatedInvoice.getPurchaseNumber());
            invoiceUpdate.setPurchaseDate(updatedInvoice.getPurchaseDate());
            invoiceUpdate.setSupplierName(updatedInvoice.getSupplierName());
            invoiceUpdate.setDiscount(updatedInvoice.getDiscount());
            invoiceUpdate.setQuantity(updatedInvoice.getQuantity());
            invoiceUpdate.setVatTax(updatedInvoice.getVatTax());
            invoiceUpdate.setNote(updatedInvoice.getNote());
            
            return invoiceRepository.save(invoiceUpdate);
        } else {
            throw new ResourceNotFoundException("Record not found with Invoice Number: " + updatedInvoice.getInvoice_number());
        }
    }
	
	@Override
	public void deleteInvoice(Long invoice_number) {
	    Optional<Invoice> invoiceDB = invoiceRepository.findById(invoice_number);
	    if (invoiceDB.isPresent()) {
	        invoiceRepository.delete(invoiceDB.get());
	    } else {
	        throw new ResourceNotFoundException("No invoice found with Invoice Number: " + invoice_number);
	    }
	}

	
}