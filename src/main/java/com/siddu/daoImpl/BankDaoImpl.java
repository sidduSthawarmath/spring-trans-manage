package com.siddu.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.siddu.dao.BankDao;
import com.siddu.domain.Account;

@Repository
public class BankDaoImpl implements BankDao {

	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate = null;

	public void withdraw(Account fromAccount, Account toAccount, Double amount) throws InsufficientBalance {
		jdbcTemplate = new JdbcTemplate(dataSource);
		Account accountDetails = getDataFromDBbyAccountNum(fromAccount.getAccountNumber());
		if (amount > accountDetails.getBalance()) {
			throw new InsufficientBalance("Infucient balance");
		} else {
			Double balance = accountDetails.getBalance() - amount;
			jdbcTemplate.update("update account set balance='" + balance + "' where accountNumber='"
					+ fromAccount.getAccountNumber() + "'");
		}
		System.out.println("Amount Rs." + amount + " Transfered from account " + fromAccount.getAccountNumber() + " to "
				+ toAccount.getAccountNumber());
	}
	
	

	public void deposit(Account fromAccount, Account toAccount, Double amount) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		Account accountDetails = getDataFromDBbyAccountNum(toAccount.getAccountNumber());
		Double balance = accountDetails.getBalance() + amount;

		jdbcTemplate.update("update account set balance='" + balance + "' where accountNumber='"
				+ toAccount.getAccountNumber() + "'");
	}

	private Account getDataFromDBbyAccountNum(Long long1) {
		Account accDetails = jdbcTemplate.queryForObject(
				"select accountNumber,accountType,balance,accountHolderName from account where accountNumber='" + long1
						+ "'",
				new RowMapper<Account>() {
					public Account mapRow(ResultSet arg0, int arg1) throws SQLException {
						Account account = new Account();
						account.setAccountNumber(arg0.getLong(1));
						account.setAccountType(arg0.getString(2));
						account.setBalance(arg0.getDouble(3));
						return account;
					}
				});
		return accDetails;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
