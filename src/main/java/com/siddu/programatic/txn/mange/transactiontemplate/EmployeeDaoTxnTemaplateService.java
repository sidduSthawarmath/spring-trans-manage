package com.siddu.programatic.txn.mange.transactiontemplate;

import com.siddu.domain.Employee;

public interface EmployeeDaoTxnTemaplateService {

	public void saveEmpDetails(Employee emp);
	
	public void saveEmpDetailsUsingPlatformTxnmanger(Employee emp);
}
