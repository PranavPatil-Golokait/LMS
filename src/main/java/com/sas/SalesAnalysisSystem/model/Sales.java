package com.sas.SalesAnalysisSystem.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_id")
    private Long salesId;
    
    @OneToOne
    @JoinColumn(name = "invoice_no") 
    private Invoice invoice;

    @Column(name = "no_of_product_sold")
    private int numberOfProductSold;

    @Column(name = "total_amount")
    private int totalAmount;
    
    @Column(name = "total_quantity")
    private int totalQuantity;
    
    @CreationTimestamp
    @Column(name = "sales-created-date")
    private LocalDateTime salesCreatedDate;

	public Long getSalesId() {
		return salesId;
	}

	public void setSalesId(Long salesId) {
		this.salesId = salesId;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public int getNumberOfProductSold() {
		return numberOfProductSold;
	}

	public void setNumberOfProductSold(int numberOfProductSold) {
		this.numberOfProductSold = numberOfProductSold;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public LocalDateTime getSalesCreatedDate() {
		return salesCreatedDate;
	}

	public void setSalesCreatedDate(LocalDateTime salesCreatedDate) {
		this.salesCreatedDate = salesCreatedDate;
	}

	public Sales(Long salesId, Invoice invoice, int numberOfProductSold, int totalAmount, int totalQuantity,
			LocalDateTime salesCreatedDate) {
		super();
		this.salesId = salesId;
		this.invoice = invoice;
		this.numberOfProductSold = numberOfProductSold;
		this.totalAmount = totalAmount;
		this.totalQuantity = totalQuantity;
		this.salesCreatedDate = salesCreatedDate;
	}

    
}
