package dao;

import java.util.List;

import domaine.Solde;

public interface IdaoSolde {
	
	public List<Solde> findAll();
	public Solde getSolde(int idClient);

}
