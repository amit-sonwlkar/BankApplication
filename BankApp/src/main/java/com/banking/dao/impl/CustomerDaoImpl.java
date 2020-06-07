package com.banking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.dao.CustomerDao;
import com.banking.modal.Customers;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customers> getAll() {
		Session session = sessionFactory.openSession();
		Query query = (Query) session.createQuery("from Customers");
		@SuppressWarnings("unchecked")
		List<Customers> customersList = query.getResultList();
		if(customersList.isEmpty())
			return new ArrayList<Customers>();
		else 
			return customersList;
	}

	@Override
	public void add(Customers customers) {
		Session session = sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		try {
			session.saveOrUpdate(customers);	
			tx.commit();
		} catch (SecurityException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void update(Customers customers) {
		Session session = sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		try {
			session.update(customers);	
			tx.commit();
		} catch (SecurityException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void delete(Customers customers) {
		Session session = sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		Query query = session.createQuery("delete from Customers c where c.customerId=:customerId");
		
		query.setParameter("customerId", customers.getCustomerId());
		@SuppressWarnings({ "unchecked", "unused" })
        int count = query.executeUpdate();
		tx.commit();
	}

	@Override
	public Customers get(Long customerId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customers where customerId=:customerId");
		query.setParameter("customerId", customerId);
		@SuppressWarnings("unchecked")
		List<Customers> customerList= query.getResultList();

		if(customerList.isEmpty())
			return new Customers();
		else
			return customerList.get(0);
	}

}
