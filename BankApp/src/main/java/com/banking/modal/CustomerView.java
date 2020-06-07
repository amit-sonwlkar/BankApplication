package com.banking.modal;

import java.io.Serializable;

import javax.persistence.Entity;
/**
 * 
 */
public class CustomerView implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long customerId ;
	private String firstName ;
	private String lastName ;
	private String address ;
	private String accountType ;
	
	
	
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}	
}
