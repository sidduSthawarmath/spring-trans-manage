package com.siddu.dao;

import com.siddu.daoImpl.InsufficientBalance;
import com.siddu.domain.Account;

public interface BankDao {

	public void withdraw(Account fromAccount, Account toAccount, Double amount) throws InsufficientBalance;

	public void deposit(Account fromAccount, Account toAccount, Double amount);
}
