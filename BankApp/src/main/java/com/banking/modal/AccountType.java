package com.banking.modal;

public enum AccountType {

	ACC_SAVING("SAVING"),
	ACC_CURRENT("CURRENT"),
	ACC_CHECKING("CHECKING");

	public String accountType;
	public String getAccountType() {
		return accountType;
	}
	AccountType(String accountType){
		this.accountType = accountType;
	}	

}
