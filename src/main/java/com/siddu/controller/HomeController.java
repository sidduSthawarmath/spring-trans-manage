package com.siddu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("home")
@RestController
public class HomeController {

	@RequestMapping(value = "msg", method = RequestMethod.GET)
	public String homePage() {

		return "home";
	}

}
