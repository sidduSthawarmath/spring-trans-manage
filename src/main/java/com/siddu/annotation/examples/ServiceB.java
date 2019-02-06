package com.siddu.annotation.examples;

import org.springframework.stereotype.Component;

@Component("serviceB")
public class ServiceB implements MyService {

	public void printServiceName() {
		System.out.println("This is service B class");
	}

}
