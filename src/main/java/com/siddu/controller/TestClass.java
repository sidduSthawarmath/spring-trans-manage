package com.siddu.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.siddu.service.BankService;

public class TestClass {
	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-servlet.xml");
		
		context.getBean("BankService",BankService.class);

	}
}
