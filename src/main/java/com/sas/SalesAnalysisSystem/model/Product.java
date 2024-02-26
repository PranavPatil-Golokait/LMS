package com.sas.SalesAnalysisSystem.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="product")
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @ManyToOne
	 @JoinColumn(name = "distributor_id") // This is the foreign key in the product table
	 private Distributor distributor;
	 
	 @ManyToOne
	 @JoinColumn(name = "invoice_id") 
	 private Invoice invoice;
	
	@Column(name = "product_name")
	private String productName;

	@Column(name = "image")
	private String image;
	
	@Column(name = "price")
	private int  price;
	
	@ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
	
	@Column(name="is_active")
	private Boolean isActive= true;
	
	
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@CreationTimestamp
	private LocalDateTime updatedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		
		this.category = category;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public Product() {
		
	}
	
	public Product(String productName, String image, int price, Category category, Boolean isActive) 
	{
		this.productName = productName;
        this.image = image;
        this.price = price;
        this.category = category;
        this.isActive = isActive;
	        
	}


	@Override
	public String toString() {
		return "Product ["+" name=" + productName + ", image=" + image + ", price=" + price + ", category="
				+ category + ", isActive=" + isActive + "]";
	}
	
	

}
