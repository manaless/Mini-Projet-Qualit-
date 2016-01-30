package test;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoClient;
import dao.DaoTransaction;
import domaine.Client;
import domaine.Transaction;

public class Test {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bat/batchcontext.xml");
		JobLauncher jobLauncher=(JobLauncher) context.getBean("jobLauncher");
		Job job =(Job) context.getBean("importTransactions");
		jobLauncher.run(job, new JobParameters());

	}

}
