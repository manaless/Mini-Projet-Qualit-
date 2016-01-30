package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domaine.Client;

@Repository
public class Dao implements Idao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Client> findAll() {
		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from Client");
			return query.list();
		}

		finally {
			session.close();
		}
	}

	public Client getClient(int id) {
		Session session = sessionFactory.openSession();
		try {
			return (Client) session.get(Client.class, id);
		} finally {
			session.close();
		}
	}

	public void addClient(Client client) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			session.saveOrUpdate(client);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		} finally {
			session.close();
		}
	}

	public int findByLogin(String login) {

		Session session = sessionFactory.openSession();

			Query query = session.createQuery("from Client c where c.compte.login like :login");
			query.setParameter("login", login);
			List<Client> list= query.list();
			Client client=  list.get(0);
			session.close();

		return client.getIdClient();
	}

}
