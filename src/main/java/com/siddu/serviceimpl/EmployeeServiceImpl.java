package com.siddu.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siddu.dao.EmployeeDao;
import com.siddu.programatic.txn.mange.transactiontemplate.Employee;
import com.siddu.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDao;

	public Employee saveEmployeeDetails(Employee emp) {
		return employeeDao.saveEmployeeDetails(emp);
	}
	
	
	
}
