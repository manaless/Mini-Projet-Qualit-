package bat;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.Dao;
import dao.DaoClient;
import domaine.Client;
import domaine.Compte;
import domaine.Solde;
import domaine.Transaction;

@Service("transactionProcessor")
public class TransactionProcessor implements ItemProcessor<Transaction, Transaction> {

	DaoClient dao;
	Dao daoS;

	@Autowired
	public void setDaoS(Dao daoS) {
		this.daoS = daoS;
	}

	@Autowired
	public void setDao(DaoClient dao) {
		this.dao = dao;
	}

	public Transaction process(final Transaction transactionInput) throws Exception {
		Transaction transactionOutput = null;
		transactionOutput = new Transaction();
		Client client = dao.findById(transactionInput.getClient().getIdClient());
		if ("retracted".equals(transactionInput.getType())) {
			Solde solde = daoS.findByIdClient(client.getIdClient());
			System.out.println("---------------------"+solde.getSolde()+"----------------------");
			daoS.updateSolde(solde, transactionInput.getMontant());
			System.out.println("---------------------"+solde.getSolde()+"----------------------");
			
			transactionOutput.setIdTransaction(transactionInput.getIdTransaction());
			transactionOutput.setType(transactionInput.getType());
			transactionOutput.setClient(client);
			transactionOutput.setMontant(transactionInput.getMontant());
			transactionOutput.setDate(transactionInput.getDate());
			transactionOutput.setEtat("Réglé");
		} else {
			transactionOutput.setIdTransaction(transactionInput.getIdTransaction());
			transactionOutput.setType(transactionInput.getType());
			transactionOutput.setClient(client);
			transactionOutput.setMontant(transactionInput.getMontant());
			transactionOutput.setDate(transactionInput.getDate());
			transactionOutput.setEtat("-");

		}
		return transactionOutput;
	}
}
