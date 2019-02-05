package com.siddu.programatic.txn.mange.transactiontemplate;

public interface EmployeeDaoTxnTemaplateService {

	public void saveEmpDetails(Employee emp);
	
	public void saveEmpDetailsUsingPlatformTxnmanger(Employee emp);
}
