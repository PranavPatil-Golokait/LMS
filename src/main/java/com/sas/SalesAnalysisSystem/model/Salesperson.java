package com.sas.SalesAnalysisSystem.model;
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
    @Column(name = "SalespersonID")
    private int salespersonId;

    @ManyToOne
    @JoinColumn(name = "DistributorID", referencedColumnName = "DistributorID")
    private Distributor distributor;

    @Column(name = "Name")
    private String name;

    @Column(name = "ContactNumber")
    private String contactNumber;

    @Column(name = "Email")
    private String email;

	public int getSalespersonId() {
		return salespersonId;
	}

	public void setSalespersonId(int salespersonId) {
		this.salespersonId = salespersonId;
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

	public Salesperson(int salespersonId, Distributor distributor, String name, String contactNumber, String email) {
		this.salespersonId = salespersonId;
		this.distributor = distributor;
		this.name = name;
		this.contactNumber = contactNumber;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Salesperson [salespersonId=" + salespersonId + ", distributor=" + distributor + ", name=" + name
				+ ", contactNumber=" + contactNumber + ", email=" + email + "]";
	}
}
