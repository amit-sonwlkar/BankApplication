package com.banking.service;
import java.util.List;
import com.banking.modal.Customers;
public interface CustomerService {
	public List<Customers>getAll();
	public void add(Customers customers);
	public void update(Customers customers);
	public void delete(Customers customers);
	public Customers  get(Long customerId);
}
