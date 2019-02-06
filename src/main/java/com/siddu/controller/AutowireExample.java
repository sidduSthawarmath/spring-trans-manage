package com.siddu.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.siddu.util.Student;
import com.siddu.util.Student1;
import com.siddu.util.Student2;

@Controller
@RequestMapping("autowire")
public class AutowireExample {
	
	
	//Filed level autowiring
	@Autowired
	@Qualifier("studentUtil")
	Student studentUtil;
	
	Student1 student1; 
	
	//Setter autowiring
	@Autowired
	public void setStudent1(Student1 student1) {
		this.student1 = student1;
	}
	
	
	Student2 student2;
	
	
	//Constructor autowiring
	@Autowired
	public AutowireExample(Student2 student2) {
		this.student2=student2;
	}

	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String testBeanAndConfiguration() {
	
		studentUtil.test();
		student1.test();
		student2.test();
		
		return "Success";
	}
	
	
	
	
	
	
	
	
}
