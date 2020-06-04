package com.banking.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dao.CustomerDao;
import com.banking.modal.Customers;
import com.banking.service.CustomerService;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerDao customerDao;
	
	
	@Override
	public List<Customers> getAll() {
		return customerDao.getAll();
	}

	@Override
	public void add(Customers customers) {
		customerDao.add(customers);		
	}

	@Override
	public void update(Customers customers) {
		customerDao.update(customers);		
	}

	@Override
	public void delete(Customers customers) {
		customerDao.delete(customers);
	}

	@Override
	public Customers get(Long customerId) {
		return customerDao.get(customerId);
	}

	
}
