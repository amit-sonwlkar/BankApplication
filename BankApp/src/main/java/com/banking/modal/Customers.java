package com.banking.modal;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name = "T_CUSTOMERS")
public class Customers implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUSTOMER_ID",nullable = false)
	private Long cutomerId ;
	
	@Column(name="FIRST_NAME",nullable = false)
	private String firstName ;
	
	@Column(name="LAST_NAME",nullable = false)
	private String lastName ;
	
	@Column(name="ADDRESS",nullable = true)
	private String address ;
	
	@Column(name="SECURITY_NUMBER",nullable = false)
	private String securityNumber;
	
	@Transient
	private List<BankAccounts> bankAccountList;

	//------------------GETTER / SETTER ------------------
	
	public Long getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(Long cutomerId) {
		this.cutomerId = cutomerId;
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

	public String getSecurityNumber() {
		return securityNumber;
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

	public void setSecurityNumber(String securityNumber) {
		this.securityNumber = securityNumber;
	}

	@OneToMany(mappedBy ="customerObj")
	public void setBankAccountList(List<BankAccounts> bankAccountList) {
		this.bankAccountList = bankAccountList;
	}
	
	
	
}
