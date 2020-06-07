package com.banking.modal;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "T_CUSTOMERS")
public class Customers implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID",nullable = false)
	private Long customerId ;
	
	@Column(name="FIRST_NAME",nullable = false)
	private String firstName ;
	
	@Column(name="LAST_NAME",nullable = false)
	private String lastName ;
	
	@Column(name="ADDRESS",nullable = true)
	private String address ;
	
	@JsonIgnore
	@Column(name="SSN",nullable = true)
	private String ssn;
	
	@Column(name="STATUS",nullable = true)
	private Boolean status;
	
	@OneToMany(mappedBy ="customerObj",cascade = CascadeType.REMOVE)
	private List<BankAccounts> bankAccountList;

	//------------------GETTER / SETTER ------------------
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getSsn() {
		return ssn;
	}

	public List<BankAccounts> getBankAccountList() {
		return bankAccountList;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public void setBankAccountList(List<BankAccounts> bankAccountList) {
		this.bankAccountList = bankAccountList;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
	}
