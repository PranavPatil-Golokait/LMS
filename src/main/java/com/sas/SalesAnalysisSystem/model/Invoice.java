package com.sas.SalesAnalysisSystem.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long invoice_number;
    
    @CreationTimestamp
    private LocalDate invDate;

    private double netAmount;

    private double cgst;

    private double sgst;

    private double totalAmount;

    private String purchaseNumber;

    private LocalDate purchaseDate;

    private String supplierName;

    private double discount;

    private int quantity;

    private double vatTax;

    private String note;   
    
    public Invoice() {
    	
    }

	public long getInvoice_number() {
		return invoice_number;
	}

	public void setInvoice_number(long invoice_number) {
		this.invoice_number = invoice_number;
	}

	public LocalDate getInvDate() {
		return invDate;
	}

	public void setInvDate(LocalDate invDate) {
		this.invDate = invDate;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getVatTax() {
		return vatTax;
	}

	public void setVatTax(double vatTax) {
		this.vatTax = vatTax;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Invoice(long invoice_number, LocalDate invDate, double netAmount, double cgst, double sgst,
			double totalAmount, String purchaseNumber, LocalDate purchaseDate, String supplierName, double discount,
			int quantity, double vatTax, String note) {
		super();
		this.invoice_number = invoice_number;
		this.invDate = invDate;
		this.netAmount = netAmount;
		this.cgst = cgst;
		this.sgst = sgst;
		this.totalAmount = totalAmount;
		this.purchaseNumber = purchaseNumber;
		this.purchaseDate = purchaseDate;
		this.supplierName = supplierName;
		this.discount = discount;
		this.quantity = quantity;
		this.vatTax = vatTax;
		this.note = note;
	}
    
}