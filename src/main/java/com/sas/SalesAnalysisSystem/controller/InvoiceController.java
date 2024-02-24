package com.sas.SalesAnalysisSystem.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sas.SalesAnalysisSystem.exception.ResourceNotFoundException;
import com.sas.SalesAnalysisSystem.model.Invoice;
import com.sas.SalesAnalysisSystem.service.InvoiceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/create-invoice")
    public ResponseEntity<Object> createInvoice(@Valid @RequestBody Invoice invoice) {
        try {
            Invoice createdInvoice = invoiceService.createInvoice(invoice); 
            return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllInvoices() {
        try {
            List<Invoice> invoices = invoiceService.getAllInvoices();
            return ResponseEntity.ok().body(invoices);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No invoices found");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getInvoiceById(@PathVariable("id") Long id) {
        try {
            Invoice invoice = invoiceService.getInvoiceByInvoiceNumber(id);
            return ResponseEntity.ok().body(invoice);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/getinvoiceswithdate/{date}")
    public ResponseEntity<Object> getInvoiceByDate(@PathVariable LocalDate date) {
        try {
            List<Invoice> invoices = invoiceService.getInvoiceByDate(date);
            return ResponseEntity.ok().body(invoices);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update-invoice")
    public ResponseEntity<Object> updateInvoice(@RequestBody Invoice invoice) {
        try {
            Invoice updatedInvoice = invoiceService.updateInvoice(invoice); 
            return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete-invoice/{id}")
    public ResponseEntity<Object> deleteInvoice(@PathVariable Long id) {
        try {
            invoiceService.deleteInvoice(id);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
