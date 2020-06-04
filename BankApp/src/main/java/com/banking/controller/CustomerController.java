package com.banking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

	 @GetMapping("/addCustomerView")
	 public String addCustomer() {
		 return "customerView";
	 }
}
