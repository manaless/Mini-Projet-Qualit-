package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import domaine.Client;

@Repository
public class DaoClient implements IdaoClient{

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addClient(Client c) {

		Session session = sessionFactory.openSession();
		session.save(c);
	}

	@Transactional
	public Client findById(int cId) {
		Session session = sessionFactory.openSession();
		return (Client) session.get(Client.class, cId);
	}


}
