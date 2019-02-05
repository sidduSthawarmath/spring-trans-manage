package com.siddu.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.siddu.programatic.txn.mange.transactiontemplate.Employee;


public interface EmployeeDao {

	Employee saveEmployeeDetails(Employee emp);

}
