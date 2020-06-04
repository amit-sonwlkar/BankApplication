package com.banking.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.BankAccountDao;
import com.banking.modal.BankAccounts;
import com.banking.service.BankAccountService;

@Service("bankAccountService")
public class BankAccountServiceImpl implements BankAccountService{

	@Autowired
	private BankAccountDao bankAccountDao;
	
	
	@Override
	public List<BankAccounts> getAll() {
		return bankAccountDao.getAll();
	}

	@Override
	public void add(BankAccounts bankAccounts) {
		bankAccountDao.add(bankAccounts);		
	}

	@Override
	public void update(BankAccounts bankAccounts) {
		bankAccountDao.update(bankAccounts);		
	}

	@Override
	public void delete(BankAccounts bankAccounts) {
		bankAccountDao.delete(bankAccounts);		
	}

	@Override
	public BankAccounts get(Long bankAccountId) {
		return bankAccountDao.get(bankAccountId);
	}

}
