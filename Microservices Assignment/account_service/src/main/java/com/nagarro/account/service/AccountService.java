package com.nagarro.account.service;

import java.util.List;

import com.nagarro.account.entity.Account;

public interface AccountService {

	public List<Account> getAccounts(Long cusId);
	public Account addMoney(String a,Long money);
	public Account withdrawMoney(String a, Long money);
	public void deleteAccount(String accNo);
}
