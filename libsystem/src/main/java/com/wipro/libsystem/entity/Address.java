package com.wipro.libsystem.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "Address")
public class Address {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String doorNo;
	    private String street;
	    private String city;
	    private String state;
	    private String pincode;

	    public Address() {}

	    public Address(String doorNo, String street, String city, String state, String pincode) {
	        this.doorNo = doorNo;
	        this.street = street;
	        this.city = city;
	        this.state = state;
	        this.pincode = pincode;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDoorNo() {
			return doorNo;
		}

		public void setDoorNo(String doorNo) {
			this.doorNo = doorNo;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

	    
	}



   