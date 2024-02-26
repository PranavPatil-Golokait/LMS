package com.sas.SalesAnalysisSystem.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "salesperson")
public class Salesperson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
//    @ManyToOne
//    (cascade = CascadeType.REFRESH)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "distributor_id") 
    @JsonBackReference // Use this annotation to break the cyclic reference
    private Distributor distributor;

    @Column(name = "Name")
    private String name;

    @Column(name = "ContactNumber")
    private String contactNumber;

    @Column(name = "Email")
    private String email;
    

	public Long getSalespersonId() {
		return id;
	}

	public void setSalespersonId(Long salespersonId) {
		this.id = salespersonId;
	}

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public Salesperson(){
		
	}

	public Salesperson(Long salespersonId, Distributor distributor, String name, String contactNumber, String email) {
		this.id = salespersonId;
		this.distributor = distributor;
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Salesperson [salespersonId=" + id + ", distributor=" + distributor + ", name=" + name
				+ ", contactNumber=" + contactNumber + ", email=" + email + "]";
	}
}
