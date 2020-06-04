package com.banking.dao;

import java.util.List;

import com.banking.modal.BankAccounts;

public interface BankAccountDao {
	public List<BankAccounts>getAll();
	public void add(BankAccounts bankAccounts);
	public void update(BankAccounts bankAccounts);
	public void delete(BankAccounts bankAccounts);
	public BankAccounts  get(Long bankAccountId);
}
