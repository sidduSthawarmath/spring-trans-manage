package com.siddu.programatic.txn.mange.transactiontemplate;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Repository
public class EmployeeDaoTxnTemaplateServiceImpl implements EmployeeDaoTxnTemaplateService {

	private PlatformTransactionManager transactionManager;

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate = null;

	@Transactional(isolation = Isolation.DEFAULT)

	public void saveEmpDetails(Employee emp) {

		jdbcTemplate = new JdbcTemplate(dataSource);

		TransactionTemplate template = new TransactionTemplate(transactionManager);
		template.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				jdbcTemplate.update("insert into employee(name,phoneNum) values('UsingTxnTemplate','111')");

				// If Uncomment this line it throw the run time exception then
				// TransactionTemplate will manage the transaction and
				// automatically rollback the previous transaction

				/* throw new RuntimeException("Test the rollback scenario"); */
			}

		});

	}

	public void saveEmpDetailsUsingPlatformTxnmanger(Employee emp) {

		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);

		jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			jdbcTemplate.update("insert into employee(name,phoneNum) values('PlatformTxnmanger','111')");

			// Intentionally write code for arithmatic exception to avoid the
			// commit and continue the transaction rollback
			int x = 100 / 0;

			transactionManager.commit(status);
		} catch (Exception e) {
			System.out.println("Error in creating record, rolling back");
			transactionManager.rollback(status);
		}

	}

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
