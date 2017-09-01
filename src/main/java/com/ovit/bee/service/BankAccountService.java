package com.ovit.bee.service;

import com.ovit.bee.pojo.BankAccount;

public interface BankAccountService {
	BankAccount selectById(Integer id );
	
	BankAccount selectByAccount(String account);
	
	int  insert(BankAccount account);
}
