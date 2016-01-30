package dao;

import java.util.List;

import domaine.Transaction;

public interface IdaoTransaction {
	
	public List<Transaction> findAll();
	public Transaction getByClient(int idClient);
	public List<Transaction> findAllByClient(int idClient);
}
