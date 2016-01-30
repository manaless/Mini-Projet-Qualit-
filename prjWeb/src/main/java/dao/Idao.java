package dao;

import java.util.List;

import domaine.Client;

public interface Idao {
	
	public List<Client> findAll();
	public Client getClient(int id);
	public void addClient(Client client);
	public int findByLogin(String login);

}
