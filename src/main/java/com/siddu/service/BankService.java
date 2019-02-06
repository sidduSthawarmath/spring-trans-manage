package com.siddu.service;

import com.siddu.daoImpl.InsufficientBalance;
import com.siddu.domain.Account;

public interface BankService {
	public void transferFund(Account fromAccount, Account toAccount, Double balance);
}
