package com.nagarro.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nagarro.account.entity.Account;
import com.nagarro.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class accountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/customer/{id}")
	public List<Account> getAccounts(@PathVariable("id") Long cusId){
		return this.accountService.getAccounts(cusId);
	}
	
	@GetMapping("/addMoney/{account}/{money}")
	public Account depositMoney(@PathVariable("account") String accNo,@PathVariable("money") Long money)
	{
		return this.accountService.addMoney(accNo,money);
	}

	@GetMapping("/withdrawMoney/{account}/{money}")
	public Account withdrawMoney(@PathVariable("account") String accNo,@PathVariable("money") Long money)
	{
		return this.accountService.withdrawMoney(accNo,money);
	}
	
	@GetMapping("/remove/{account}")
	public void deleteAccount(@PathVariable("account") String accNo)
	{
	 this.accountService.deleteAccount(accNo);
	 return;
	}
}
