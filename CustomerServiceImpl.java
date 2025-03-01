 package com.CustomerRelationshipManagement.service.imple;

import java.awt.JobAttributes;
import java.lang.reflect.Method;
import java.util.List;

import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.CustomerRelationshipManagement.dao.CustomerDao;
import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

import jakarta.websocket.server.ServerEndpoint;
@Service
public  class CustomerServiceImpl implements CustomerService
{

	CustomerDao customerDao;//you can use autowire or construtor injection to create and manage its object by spring
	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}
	@Override
	public String insertCustomer(Customer customer)
	
	{
		//here you can just call dao method to insert but first you need to create object of Dao
		//obj banayega kon spring boot
		
		return customerDao.insertCustomer(customer);
	}
	@Override
	public List<Customer> getCustomersList()
	{
		//here you can just call dao method to get kiuki dao me hamne pahle hi wo method bana diya using session method but first you need to create object of Dao
				//obj banayega kon spring boot
		
		return customerDao.getCustomersList();
	}
	@Override
	public Customer getCustomerById(int id) {
		//Dao me Jo getCustomerId Method hai usko call krlo or wo databse se call krke return krega using session object
		
		return customerDao.getCustomerById(id);
	}
	@Override
	public String updateCustomer(Customer customer) {
		
		return customerDao.updateCustomer(customer);
	}
	@Override
	public String deleteCustomerById(int id) {
		
		return customerDao.deleteCustomerById( id);
	}
	@Override
	public String insertMultipleCustomers(List<Customer> customers) {
	
		return customerDao.insertMultipleCustomers(customers);
	}
	@Override
	
	public List<Customer> getCustomerByFirstName(String firstname) {
		
		return customerDao.getCustomerByFirstName(firstname);
	}
	@Override
	public List<Customer> getCustomerByLessthanAge(int age) {
		
		return customerDao.getCustomerByLessthanAge(age);
	}
	@Override
	public List<Customer> getCustomerByAge(int age)
	{
		return customerDao.getCustomerByAge( age);
	}

}
