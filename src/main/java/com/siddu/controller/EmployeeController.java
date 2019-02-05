package com.siddu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.siddu.domain.Employee;
import com.siddu.service.EmployeeService;

@RequestMapping("emp")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ResponseBody
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public Employee saveEmployeeDetails(@RequestBody String empData) {
		Gson gson=new Gson();
		Employee employee=gson.fromJson(empData, Employee.class);
		employee = employeeService.saveEmployeeDetails(employee);
		return employee;
	}

}
