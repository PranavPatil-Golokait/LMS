package com.sas.SalesAnalysisSystem.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sales_id")
    private Long salesId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "distributor_id")
    private Distributor distributor;

    @ManyToOne
    @JoinColumn(name = "salesperson_id")
    private Salesperson salesperson;

    @Column(name = "no_of_product_sold")
    private int numberOfProductSold;

    @Column(name = "total_amount")
    private int totalAmount;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Long getSalesId() {
		return salesId;
	}



	public void setSalesId(Long salesId) {
		this.salesId = salesId;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public Distributor getDistributor() {
		return distributor;
	}



	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}



	public Salesperson getSalesperson() {
		return salesperson;
	}



	public void setSalesperson(Salesperson salesperson) {
		this.salesperson = salesperson;
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
	public Sales() {
		
	}


	public Sales(Long salesId, Product product, Distributor distributor, Salesperson salesperson,
			int numberOfProductSold, int totalAmount, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.salesId = salesId;
		this.product = product;
		this.distributor = distributor;
		this.salesperson = salesperson;
		this.numberOfProductSold = numberOfProductSold;
		this.totalAmount = totalAmount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}



	@Override
    public String toString() {
        return "Sales{" +
                "salesId=" + salesId +
                ", product=" + product +
                ", distributor=" + distributor +
                ", salesperson=" + salesperson +
                ", numberOfProductSold=" + numberOfProductSold +
                ", totalAmount=" + totalAmount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
