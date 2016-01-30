package dao;

import domaine.Solde;

public interface Idao {
	
	public void addSolde(Solde s);
	public void updateSolde(Solde s,int solde);
	 public Solde findById(int sId);
	 public Solde findByIdClient(int cId); 

}
