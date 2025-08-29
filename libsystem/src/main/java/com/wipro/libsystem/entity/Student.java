package com.wipro.libsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String username;
	    private String password;
	    private String email;
	    private String phoneNo;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id", referencedColumnName = "id")
	    private Address address;

	    public Student() {}

	    public Student(String username, String password, String email, String phoneNo, Address address) {
	        this.username = username;
	        this.password = password;
	        this.email = email;
	        this.phoneNo = phoneNo;
	        this.address = address;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public Long getStudentId() {
			// TODO Auto-generated method stub
			return null;
		}

	}


