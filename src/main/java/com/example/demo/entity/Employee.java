package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="First_Name")
	private String first_Name;
	

	@Column(name="Last_Name")
	private String last_Name;
	
	@Column(name="Email_Id")
	private String emailId;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String first_Name, String last_Name, String emailId) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.emailId = emailId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_Name=" + first_Name + ", last_Name=" + last_Name + ", emailId=" + emailId
				+ "]";
	}
	
	
}
