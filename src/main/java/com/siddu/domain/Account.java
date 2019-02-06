package com.siddu.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

	public Account() {
	}

	public Account(Long accountNumber, String accountType, Double balance, String accountHolderName) {
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.accountHolderName = accountHolderName;
	}

	@Id
	private Long accountNumber;

	private String accountType;

	private Double balance;

	private String accountHolderName;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

}
