package com.siddu.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siddu.annotation.examples.CustomMessages;
import com.siddu.annotation.examples.DateUtil;
import com.siddu.annotation.examples.MyService;

@Controller
@RequestMapping("annotation")
public class AnnotationController {

	@Autowired
	DateUtil dateUtil;

	@Autowired
	CustomMessages customMessages;

	
	@Resource(name="${beanName}")
	MyService myService;

	

	@RequestMapping(value = "beanAnn", method = RequestMethod.GET)
	public String testBeanAndConfiguration() {
		System.out.println("Today Date:" + dateUtil.currentDate());
		System.out.println("Msg:" + customMessages.welcomeMsg());
		
		myService.printServiceName();
		return "Success";
	}
	
	
	@RequestMapping(value = "beanInjDynamic", method = RequestMethod.GET)
	public String dynamicBeanInjection() {
		myService.printServiceName();
		return "Success";
	}

}
