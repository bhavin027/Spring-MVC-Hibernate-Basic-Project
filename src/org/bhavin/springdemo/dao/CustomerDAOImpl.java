package org.bhavin.springdemo.dao;

import java.util.List;

import org.bhavin.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	//inject session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		
		// get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//execute query and get result
		List<Customer> customers = theQuery.getResultList();
		
		//return result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/update session to database
		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {
		
		//get hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	
		//create query to read data from db
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		//return result
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {

		// get hidernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get object
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		//delete session from database
		currentSession.delete(theCustomer);
		
	}

}
