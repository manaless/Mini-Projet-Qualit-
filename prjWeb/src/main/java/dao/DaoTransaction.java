package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domaine.Transaction;

@Repository
public class DaoTransaction implements IdaoTransaction {

	// Configuration configuration = new
	// Configuration().configure("ma/ensa/util/hibernate.cfg.xml");
	// SessionFactory sessionFactory = configuration.buildSessionFactory();

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Transaction> findAll() {
		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from Transaction");
			return query.list();
		}

		finally {
			session.close();
		}
	}

	public Transaction getByClient(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Transaction> findAllByClient(int idClient) {
		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from Transaction t where t.client.idClient =?");
			query.setInteger(0, idClient);
			return query.list();
		}

		finally {
			session.close();
		}
	}

}
