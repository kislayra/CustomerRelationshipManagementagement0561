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

	CustomerDao customerDao;
	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}
	@Override
	public String insertCustomer(Customer customer)
	
	{
		
		
		return customerDao.insertCustomer(customer);
	}
	@Override
	public List<Customer> getCustomersList()
	{
		
		
		return customerDao.getCustomersList();
	}
	@Override
	public Customer getCustomerById(int id) {
		
		
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
