package org.bhavin.springdemo.dao;

import java.util.List;

import org.bhavin.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
