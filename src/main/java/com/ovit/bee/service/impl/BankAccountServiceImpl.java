package com.ovit.bee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ovit.bee.IDao.BankAccountMapper;
import com.ovit.bee.pojo.BankAccount;
import com.ovit.bee.service.BankAccountService;
@Service
public class BankAccountServiceImpl implements BankAccountService {
	@Autowired
	private BankAccountMapper BankAccountIao;
	@Override
	public BankAccount selectById(Integer id) {
		
		return BankAccountIao.selectById(id);
	}

	@Override
	public int insert(BankAccount account) {
		return BankAccountIao.insert(account);
	}

	@Override
	public BankAccount selectByAccount(String account) {
		return BankAccountIao.selectByAccount(account);
	}

}
