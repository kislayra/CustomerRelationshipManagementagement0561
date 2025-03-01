package com.CustomerRelationshipManagement.service;

import java.util.List;

import com.CustomerRelationshipManagement.entity.Customer;

public interface CustomerService 
{
  
	String insertCustomer(Customer customer);//Dao se string return ho rha hai "customer insertion success" to yha se bhi whi return hoga n;
	
	List<Customer> getCustomersList();
	
	Customer getCustomerById(int id);
	
   String updateCustomer(Customer customer);
   
    String deleteCustomerById(int id);
    
    String insertMultipleCustomers(List<Customer> customers);
    
     List<Customer> getCustomerByFirstName(String firstname);
     
     List<Customer> getCustomerByLessthanAge(int age);
     
      List<Customer> getCustomerByAge(int age);


 	
}
