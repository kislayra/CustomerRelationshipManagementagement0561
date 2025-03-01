package com.CustomerRelationshipManagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;
@RestController
@RequestMapping("/api/customers")
public class CustomerController 
{
	


	
	CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	

	@PostMapping("/insert")
	public String insertCustomer(@RequestBody Customer customer)
	{
		return customerService.insertCustomer(customer);
		
	}
      @GetMapping
	public List<Customer> getCustomersList()
	{
		List<Customer> list = customerService.getCustomersList();
		return list;
	}
      @GetMapping("/{id}")
      public Customer getCustomerById(@PathVariable int id)
      {
    	  return customerService.getCustomerById(id);
      }
      @PutMapping
      public String updateCustomer(@RequestBody Customer customer)
      {
    	  return customerService.updateCustomer(customer);
      }
      @DeleteMapping("/{id}")
      public String deleteCustomerById(@PathVariable int id)
      {
    	  return customerService.deleteCustomerById(id);
      }
      @PostMapping
      public String insertMultipleCustomers(@RequestBody List<Customer> customers)
      {
    	  return customerService.insertMultipleCustomers(customers);
      }
      @GetMapping("/byname/{firstname}")
      public List<Customer> getCustomerByFirstName(@PathVariable String firstname)
      {
    	  return customerService.getCustomerByFirstName(firstname);
      }
      @GetMapping("/bylessthanage/{age}")
      public List<Customer> getCustomerByLessthanAge(@PathVariable int age)
      {
    	  return customerService.getCustomerByLessthanAge(age);
      }
      @GetMapping("/byage/{age}")
  	   public List<Customer> getCustomerByAge(@PathVariable int age)
  	   {
  		   return customerService.getCustomerByAge( age);
  	   }
}
