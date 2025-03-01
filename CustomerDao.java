package com.CustomerRelationshipManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.sql.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CustomerRelationshipManagement.entity.Customer;
import com.CustomerRelationshipManagement.service.CustomerService;

import jakarta.persistence.Query;


@Repository
public class CustomerDao 
{

	SessionFactory sf;

    public CustomerDao(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	public String insertCustomer(Customer customer)
	{
		Session session = sf.openSession();
		
		Transaction tr = session.beginTransaction();
		
		session.persist(customer); 
		tr.commit();
		
		return "customer insert successfully";
	}
	
	public List<Customer> getCustomersList()
	{
		 Session session = sf.openSession();
		 return session.createQuery("from Customer",Customer.class).list();
		 
	}
	
	public Customer getCustomerById(int id)
	{
		Session session = sf.openSession();
		return session.get(Customer.class, id);
		
	}
	
	public String updateCustomer(Customer customer)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		//session.update(customer);
		session.merge(customer);
		tr.commit();
		session.close();
		
		return "updated successfully";
	}
	
	public String deleteCustomerById(int id)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Customer customer = session.get(Customer.class, id);
	
		session.remove(customer);
		tr.commit();
		session.close();
		return "customer removed";
		
	}
	
	public String insertMultipleCustomers(List<Customer> customers)
	{
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		for(Customer c: customers)
		{
			session.save(c);
		}
		tr.commit();
		session.close();
		return "multiple insertion completed";
	}

	public List<Customer> getCustomerByFirstName(String firstname)
	{
		Session session = sf.openSession();
		
		
		org.hibernate.query.Query<Customer> customers =session.createQuery("from Customer c where c.firstname=:firstname",Customer.class);
		customers.setParameter("firstname", firstname);
		List<Customer> list = customers.list();
		return list;

	}
    
	public List<Customer> getCustomerByLessthanAge(int age)
	{
		Session session = sf.openSession();
		
	
		org.hibernate.query.Query<Customer> customers =session.createQuery("from Customer c where c.age<:age",Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();
		return list;

	}
	public List<Customer> getCustomerByAge(int age)
	{
		Session session = sf.openSession();
		
		org.hibernate.query.Query<Customer> customers =session.createQuery("from Customer c where c.age=:age",Customer.class);
		customers.setParameter("age", age);
		List<Customer> list = customers.list();
		return list;

	}
}
