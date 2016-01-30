package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;


import domaine.Client;
import domaine.Solde;

@Repository
public class Dao implements Idao {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void addSolde(Solde p) {

		Session session = sessionFactory.openSession();
		session.save(p);
	}

	@Transactional
	public void updateSolde(Solde p, int solde) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		p.setSolde(p.getSolde()+solde);
		session.update(p);
		session.getTransaction().commit();
	}

	@Transactional
	public Solde findById(int sId) {
		Session session = sessionFactory.openSession();
		return (Solde) session.get(Solde.class, sId);
	}

	@Transactional
	public Solde findByIdClient(int cId) {
		Session session = sessionFactory.openSession();
		String sql = "FROM Solde s WHERE s.client.idClient like :cId";
		Query q=session.createQuery(sql);
		q.setInteger("cId", cId );
		List<Solde> list= q.list();
		Solde s=list.get(0);
		session.close();
		return s ;
	}

}
