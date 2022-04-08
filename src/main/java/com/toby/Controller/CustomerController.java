package com.toby.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.toby.Dao.CustomerDaoIntf;
import com.toby.Model.Customer;
import com.toby.Service.CustomerServiceIntf;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	public CustomerServiceIntf customerServiceIntf;
	
	@GetMapping("/list")
	public String home(Model model) {
		List<Customer> customers = customerServiceIntf.getAllCustomers();
		model.addAttribute("customers", customers);
		return "CustomerList";
	}
	
	@GetMapping("/showFormForAdd")
	public String studentForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "CustomerForm";
	}
	
	@PostMapping("/processForm")
	public String processForm(@ModelAttribute("customer")Customer customer) {
		System.out.print("id: [" + customer.getId() + "]");
		customerServiceIntf.addCustomer(customer);
		return "redirect: list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateForm(Model model,@RequestParam("custId")int id) {
		Customer customer = customerServiceIntf.getCustomer(id);
		model.addAttribute("customer", customer);
		return "CustomerForm";
	}
	
	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("custId") int custId) {
		Customer customer = customerServiceIntf.getCustomer(custId);
		customerServiceIntf.deleteCustomer(customer);
		return "redirect: list";
	}
}
