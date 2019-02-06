package com.siddu.annotation.examples;

import org.springframework.stereotype.Component;

@Component("serviceA")
public class ServiceA implements MyService {

	public void printServiceName() {
		System.out.println("This is service A class");
	}

}
