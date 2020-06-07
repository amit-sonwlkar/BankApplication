package com.banking.modal;

import java.io.Serializable;
import java.math.BigDecimal;

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

	@Column(name="BALANCE_AMMOUONT",nullable = false)
	private BigDecimal balanceAmount;	
	
	@Column(name="CURRENCY",nullable = true)
	private String currency;
	
	@Column(name="STATUS",nullable = true)
	private Boolean status;

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

	public void setCustomerObj(Customers customerObj) {
		this.customerObj = customerObj;
	}

	public BigDecimal getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(BigDecimal balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
}	
