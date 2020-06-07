package com.banking.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.banking.dao.BankAccountDao;
import com.banking.modal.BankAccounts;

@Repository("bankAccountDao")
public class BankAccountDaoImpl implements BankAccountDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<BankAccounts> getAll() {
		Session session = sessionFactory.openSession();
		Query query = (Query) session.createQuery("from BankAccounts");
		@SuppressWarnings("unchecked")
		List<BankAccounts> bankAccountsList = query.getResultList();
		if(bankAccountsList.isEmpty())
			return new ArrayList<BankAccounts>();
		else 
			return bankAccountsList;
	}

	@Override
	public void add(BankAccounts bankAccounts) {
		Session session = sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		try {
			session.saveOrUpdate(bankAccounts);	
			tx.commit();
		} catch (SecurityException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void update(BankAccounts bankAccounts) {
		Session session = sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		try {
			session.update(bankAccounts);	
			tx.commit();
		} catch (SecurityException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	@Override
	public void delete(BankAccounts bankAccounts) {
		Session session = sessionFactory.openSession();
		Transaction tx = (Transaction) session.beginTransaction();
		Query query = session.createQuery("delete from BankAccounts ba where ba.accountId=:accountId");
		query.setParameter("accountId", bankAccounts.getAccountId());
		@SuppressWarnings({ "unchecked", "unused" })
		int count = query.executeUpdate();
		tx.commit();
	}

	@Override
	public BankAccounts get(Long accountId) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from BankAccounts where accountId=:accountId");
		query.setParameter("accountId", accountId);
		@SuppressWarnings("unchecked")
		List<BankAccounts> customerList= query.getResultList();

		if(customerList.isEmpty())
			return new BankAccounts();
		else
			return customerList.get(0);
	}

}
