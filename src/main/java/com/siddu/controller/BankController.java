package com.siddu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siddu.domain.Account;
import com.siddu.service.BankService;

@RestController
@RequestMapping("bank")
public class BankController {

	@Autowired
	private BankService bankService;

	@RequestMapping(value = "fundTransfer")
	public String fundTransfer() {

		bankService.transferFund(new Account(new Long(111), "saving", new Double(1000), "Siddu"), new Account(new Long(222), "saving", new Double(1000), "Sharnu"), new Double(100));
		
		return "Success";
	}
}
