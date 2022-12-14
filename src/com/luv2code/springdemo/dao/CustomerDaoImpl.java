package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		// create a query ... sort by first name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);
		
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//save the customer
		
		//currentSession.save(theCustomer);
		
		
		//save /update the customer finally
		currentSession.saveOrUpdate(theCustomer);
	}


	@Override
	public Customer getCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// ritrieve/read the data from the database using the primary key id
		Customer theCustomer  = currentSession.get(Customer.class, theId);
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {
		// get the current hibernate session
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//create a query to delete the customer with primary key
		Query theQuery = currentSession.createQuery("delete from Customer where id = :CustomerId");
		
		theQuery.setParameter("CustomerId", theId);
		
		theQuery.executeUpdate();
		
		
	}

}
