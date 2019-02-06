package com.siddu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.siddu.programatic.txn.mange.transactiontemplate.Employee;
import com.siddu.programatic.txn.mange.transactiontemplate.EmployeeDaoTxnTemaplateService;
import com.siddu.service.BankService;

@RequestMapping("emptxntmeplate")
@RestController
public class EmployeeControllerTxnTemplateService {

	@Autowired
	private EmployeeDaoTxnTemaplateService employeeDaoTxnTemaplateService;
	
	
	@ResponseBody
	@RequestMapping(value = "saveUsingTxnTemplate", method = RequestMethod.POST)
	public String saveEmployeeDetailsUsingTxnTemplate(@RequestBody String empData) {
		Gson gson=new Gson();
		Employee employee=gson.fromJson(empData, Employee.class);
		employeeDaoTxnTemaplateService.saveEmpDetails(employee);
		return "Success";
	}

	
	
	
	@ResponseBody
	@RequestMapping(value = "saveUsingPlatformTxnManager", method = RequestMethod.POST)
	public String saveEmployeeDetailsUsingPlatformTxnManager(@RequestBody String empData) {
		Gson gson=new Gson();
		Employee employee=gson.fromJson(empData, Employee.class);
		employeeDaoTxnTemaplateService.saveEmpDetailsUsingPlatformTxnmanger(employee);
		return "Success";
	}

}
