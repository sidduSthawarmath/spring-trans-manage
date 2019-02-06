package com.siddu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.siddu.dao.BankDao;
import com.siddu.daoImpl.InsufficientBalance;
import com.siddu.domain.Account;
import com.siddu.programatic.txn.mange.transactiontemplate.Employee;
import com.siddu.service.BankService;

@Service
public class EmployeeServiceImpl implements BankService {

	@Autowired
	private BankDao bankDao;

	// ReadOnly=true =>It only allow to read the data otherwise throws exception
	// as Connection is read-only. Queries leading to data modification are not
	// allowed.
	
	// TimeOut =>It waits for only specified time
	// rollbackFor => RollBack the transaction only specified exceptions
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, readOnly = false, timeout = 100, rollbackFor = Exception.class)
	public void transferFund(Account fromAccount, Account toAccount, Double amount) {
		try {
			bankDao.withdraw(fromAccount, toAccount, amount);
			bankDao.deposit(fromAccount, toAccount, amount);
		} catch (InsufficientBalance e) {
			System.out.println(e.getMessage());
		}

	}

}
