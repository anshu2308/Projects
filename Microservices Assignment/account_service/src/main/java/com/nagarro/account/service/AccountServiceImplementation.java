package com.nagarro.account.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nagarro.account.entity.Account;

@Service
public class AccountServiceImplementation implements AccountService{

	
	List<Account> list=List.of(new Account("aehf","BCSJ328",4L,"Saving",13980498L),
			new Account("aehf","BCSJ328",4L,"Saving",13980498L),
			new Account("aehf","BCSJ328",2L,"Saving",13980498L),
			new Account("aehf","BCSJ328",3L,"Saving",13980498L),
			new Account("aehf","BCSJ328",2L,"Saving",13980498L),
			new Account("aehf","BCSJ328",3L,"Saving",13980498L));
	
	@Override
	public List<Account> getAccounts(Long cusId) {
		return list.stream().filter(account-> account.getCusId().equals(cusId)).collect(Collectors.toList());
	}

	@Override
	public Account addMoney(String a, Long money) {
Account account=list.stream().filter(ac->ac.getAccNo().equals(a)).findAny().orElse(null);
		account.setBalance(account.getBalance()+money);
		return account;
	}

	@Override
	public Account withdrawMoney(String a, Long money) {
		
		Account account=list.stream().filter(ac->ac.getAccNo().equals(a)).findAny().orElse(null);
		account.setBalance(account.getBalance()-money);
		return account;
	}

	@Override
	public void deleteAccount(String accNo) {
		Account acc=list.stream().filter(ac->ac.getAccNo().equals(accNo)).findAny().orElse(null);
		list.remove(acc);
		
	}

}
