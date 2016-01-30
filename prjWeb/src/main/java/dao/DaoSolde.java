package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domaine.Solde;

@Repository
public class DaoSolde implements IdaoSolde {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Solde> findAll() {
		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from Solde");
			return query.list();
		}

		finally {
			session.close();
		}
	}

	public Solde getSolde(int idClient) {
		Session session = sessionFactory.openSession();

		try {
			Query query = session.createQuery("from Solde s where s.client.idClient =?");
			query.setInteger(0, idClient);
			return  (Solde) query.list().get(0);
		}

		finally {
			session.close();
		}
	}

}
