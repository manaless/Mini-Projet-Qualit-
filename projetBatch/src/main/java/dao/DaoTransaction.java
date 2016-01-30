package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domaine.Transaction;

@Repository
public class DaoTransaction implements IdaoTransaction {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addTransaction(Transaction t) {

		Session session = sessionFactory.openSession();
		session.save(t);
	}

	@Transactional
	public Transaction findById(int tId) {
		Session session = sessionFactory.openSession();
		return (Transaction) session.get(Transaction.class, tId);
	}


}
