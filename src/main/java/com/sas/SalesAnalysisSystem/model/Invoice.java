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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_number") // Specify column name
    private long invoiceNumber; // Updated property name to follow Java naming conventions
    
    @CreationTimestamp
    @Column(name = "inv_date") 
    private LocalDate invDate;
    
    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL)
    private List<Product> products;
    
    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

    @Column(name = "net_amount") 
    private double netAmount;

    @Column(name = "cgst") 
    private double cgst;

    @Column(name = "sgst")
    private double sgst;

    @Column(name = "total_amount")
    private double totalAmount;

    @Column(name = "purchase_number")
    private String purchaseNumber;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "supplier_name") 
    private String supplierName;

    @Column(name = "discount") 
    private double discount;

    @Column(name = "quantity") 
    private int quantity;

    @Column(name = "vat_tax") 
    private double vatTax;

    @Column(name = "note")
    private String note;
    
    public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}
    
    public Invoice() {
    	
    }
    public Distributor getDistributor() {
		return distributor;
	}


	public LocalDate getInvDate() {
		return invDate;
	}

	public void setInvDate(LocalDate invDate) {
		this.invDate = invDate;
	}

	public Invoice(LocalDate invDate, List<Product> products, Distributor distributor, double netAmount, double cgst,
			double sgst, double totalAmount, String purchaseNumber, LocalDate purchaseDate, String supplierName,
			double discount, int quantity, double vatTax, String note) {
		super();
		this.invDate = invDate;
		this.products = products;
		this.distributor = distributor;
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
	public long getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(long invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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

	
    
}