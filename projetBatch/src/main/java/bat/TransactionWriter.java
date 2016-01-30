package bat;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IdaoTransaction;
import domaine.Transaction;

@Service("transactionWriter")
public class TransactionWriter implements ItemWriter<Transaction> {

	private IdaoTransaction dao;

	@Autowired
	public void setDao(IdaoTransaction dao) {
		this.dao = dao;
	}

	public void write(List<? extends Transaction> items) throws Exception {
		for (Transaction transaction : items) {

			dao.addTransaction(transaction);

			System.out.println("------*******-------");

		}
	}

}