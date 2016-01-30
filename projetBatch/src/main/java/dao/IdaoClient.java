package dao;

import domaine.Client;

public interface IdaoClient {
	
	public void addClient(Client c);
	 public Client findById(int cId);

}
