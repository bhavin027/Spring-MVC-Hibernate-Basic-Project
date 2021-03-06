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
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping("/showUpateForm")
	public String showUpdateForm(@RequestParam("customerId") int theId, Model theModel) {
		
		//get customer from service
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as a model attribute to populate form
		theModel.addAttribute("customer",theCustomer);
		
		//send data over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		//delete customer using service
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}
