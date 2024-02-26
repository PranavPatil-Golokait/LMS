package com.sas.SalesAnalysisSystem.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="distributor")
public class Distributor {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
    private int distributorId;
	
	@OneToMany(mappedBy = "distributor")
	 @JsonManagedReference // Use this annotation to break the cyclic reference
	private List<Salesperson> salespersons;
	
	@OneToMany(mappedBy = "distributor")  
	private List<Product> productList;
    
	@Column(name = "Address")
    private String address;
    
    @Column(name = "State")
    private String state;
    
    @Column(name = "AgencyName")
    private String agencyName;
    
    @Column(name = "ContactPerson")
    private String contactPerson;
    
    @Column(name = "ContactNumber")
    private String contactNumber;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name="isActive")
    private Boolean isActive=true;
    
    public List<Salesperson> getSalespersons() {
		return salespersons;
	}

	public void setSalespersons(List<Salesperson> salespersons) {
		this.salespersons = salespersons;
	}

	public int getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getContactPerson() {
		return contactPerson;
	}
    public Distributor() {
		
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Distributor(List<Salesperson> salespersons, List<Product> productList, String address, String state,
			String agencyName, String contactPerson, String contactNumber, String email, Boolean isActive) {
		super();
		this.salespersons = salespersons;
		this.productList = productList;
		this.address = address;
		this.state = state;
		this.agencyName = agencyName;
		this.contactPerson = contactPerson;
		this.contactNumber = contactNumber;
		this.email = email;
		this.isActive = isActive;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
}
