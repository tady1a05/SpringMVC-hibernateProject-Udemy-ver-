package com.toby.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toby.Dao.CustomerDaoIntf;
import com.toby.Model.Customer;

@Service
public class CustomerService implements CustomerServiceIntf {
	@Autowired
	public CustomerDaoIntf customerDaoIntf;
	
	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		List<Customer> customers = customerDaoIntf.getAllCustomers();
		return customers;
	}

	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDaoIntf.addCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {
		Customer customer = customerDaoIntf.getCustomer(id);
		return customer;
	}

	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDaoIntf.deleteCustomer(customer);
	}

}
