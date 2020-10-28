package org.bhavin.springdemo.controller;

import java.util.List;

//import org.bhavin.springdemo.dao.CustomerDAO;
import org.bhavin.springdemo.entity.Customer;
import org.bhavin.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// inject the Customer Service
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		
		//get customers from the service
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
	
	@GetMapping("/showCustomerForm")
	public String showFormForAdd(Model theModel) {
		
		//create customer attribute to bind form data
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save customer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
}
