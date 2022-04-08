package com.toby.Service;

import java.util.List;

import com.toby.Model.*;

public interface CustomerServiceIntf {
	public List<Customer> getAllCustomers();
	
	public void addCustomer(Customer customer);
	
	public Customer getCustomer(int id);
	
	public void deleteCustomer(Customer customer);
}
