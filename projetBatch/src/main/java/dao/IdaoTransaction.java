package dao;

import domaine.Transaction;

public interface IdaoTransaction {
	
	public void addTransaction(Transaction t);
	 public Transaction findById(int tId);

}
