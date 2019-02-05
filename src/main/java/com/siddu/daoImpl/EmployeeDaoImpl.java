package com.siddu.daoImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.siddu.dao.EmployeeDao;
import com.siddu.programatic.txn.mange.transactiontemplate.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public Employee saveEmployeeDetails(Employee emp) {
		entityManager.persist(emp);
		return emp;
	}

}
