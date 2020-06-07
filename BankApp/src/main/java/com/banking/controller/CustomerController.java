package com.banking.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.banking.modal.BankAccounts;
import com.banking.modal.CustomerView;
import com.banking.modal.Customers;
import com.banking.service.BankAccountService;
import com.banking.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	BankAccountService bankAccountService;

	@GetMapping("/customerView")
	public String customer(Model model) {
		model.addAttribute("customers", customerService.getAll());
		return "customerView";
	}

	@GetMapping("/addCustomer")
	public String addCustomer(Model model) {
		model.addAttribute("customer", new Customers());
		model.addAttribute("bankAccount", new BankAccounts());
		return "addCustomer";
	}

	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public @ResponseBody CustomerView createOrUpdateCustomer(@RequestBody CustomerView customer) throws UnsupportedEncodingException 
	{
		Customers customersObj = new Customers();
		BankAccounts accounts = new BankAccounts();
		String source = customer.getFirstName() + customer.getLastName();
		byte[] bytes = source.getBytes("UTF-8");
		UUID uuid = UUID.nameUUIDFromBytes(bytes);
		customersObj.setFirstName(customer.getFirstName());
		customersObj.setLastName(customer.getLastName());
		customersObj.setSsn(uuid.toString());
		customersObj.setAddress(customer.getAddress());
		customerService.add(customersObj);
		
		accounts.setAccountType(customer.getAccountType());
		accounts.setCustomerObj(customersObj);
		accounts.setAccountNumber(generateAccount(customersObj.getCustomerId()));
		accounts.setBalanceAmount(BigDecimal.ZERO);
		bankAccountService.add(accounts);
		return customer;
	}

	  @RequestMapping(path = "/editCustomer", method = RequestMethod.POST)
	    public String createOrUpdateEmployee(Customers customer) 
	    {
		  customerService.add(customer);
	        return "redirect:/customerView";
	    }
	@RequestMapping(path = {"/edit", "/edit/{id}"})
	public String editCustomerById(Model model, @PathVariable("id") Optional<Long> id) 
	{
		if (id.isPresent()) {
			Customers customerObj = customerService.get(id.get());
			List<BankAccounts> bankAccounts =customerService.bankAccountList(id.get());	
			model.addAttribute("customer", customerObj);
			model.addAttribute("bankAccount", bankAccounts);
		} else {
			model.addAttribute("customer", new Customers());
		}
		return "editCustomer";
	}

	@RequestMapping(path = "/delete/{id}")
	public String deleteCustomerById(Model model, @PathVariable("id") Long id) 
	{
		Customers customerObj = customerService.get(id);
		List<BankAccounts> bankAccounts =customerService.bankAccountList(id);
		bankAccounts.forEach(ba->{
			bankAccountService.delete(ba);
		});
		customerService.delete(customerObj);
		return "redirect:/customerView";
	}
	
	public String generateAccount(Long customerId){
		String acNo = "000000"+customerId;
		
		return acNo;
	}

}
