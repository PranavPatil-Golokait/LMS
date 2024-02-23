package com.sas.SalesAnalysisSystem.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="profile")
public class Profile {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "firstName")
	    private String firstName;

		@Column(name = "lastName")
	    private String lastName;

	    @Column(name = "userName")
	    private String username;
	    
	    @Column(name = "email")
	    private String email;

	    @Column(name = "phoneNumber")
	    private String phoneNumber;

	    @Column(name = "address")
	    private String address;

	    @Column(name = "personalInformation")
	    private String personalInformation;

	    @CreationTimestamp
	    private LocalDateTime createdAt;

	    @CreationTimestamp
	    private LocalDateTime updatedAt;
	    
	    
	    public Profile() {
		}
	    

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getPersonalInformation() {
			return personalInformation;
		}

		public void setPersonalInformation(String personalInformation) {
			this.personalInformation = personalInformation;
		}

		public Profile(String firstName, String lastName, String username, String email, String phoneNumber,
				String address, String personalInformation) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
			this.username = username;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.address = address;
			this.personalInformation = personalInformation;
		}
}
