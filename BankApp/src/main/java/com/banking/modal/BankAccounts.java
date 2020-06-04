package com.banking.modal;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity 
@Table(name ="T_BANKACCOUNTS")
public class BankAccounts implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ACCOUNT_ID",nullable = false)
	private Long accountId ;

	@Column(name="ACCOUNT_NUMBER",nullable = false)
	private String accountNumber ;

	@Column(name="ACCOUNT_TYPE",nullable = false)
	private String accountType ;

	@Column(name="ADDRESS",nullable = true)
	private String address;

	@Column(name="BALANCE_AMMOUONT",nullable = false)
	private Long balanceAmount;	

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", referencedColumnName="CUSTOMER_ID") 
	private Customers customerObj;

	
	
	public Long getAccountId() {
		return accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAddress() {
		return address;
	}

	public Long getBalanceAmount() {
		return balanceAmount;
	}

	public Customers getCustomerObj() {
		return customerObj;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBalanceAmount(Long balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public void setCustomerObj(Customers customerObj) {
		this.customerObj = customerObj;
	}
}	
