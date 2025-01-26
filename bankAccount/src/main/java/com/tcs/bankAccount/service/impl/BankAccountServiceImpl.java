package com.tcs.bankAccount.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.bankAccount.entity.BankAccount;
import com.tcs.bankAccount.repository.BankAccountRepo;
import com.tcs.bankAccount.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	@Autowired
	BankAccountRepo bankAccountRepo;

	@Override
	public void createAccount(BankAccount bankAccount) {
		bankAccountRepo.save(bankAccount);
	}

	@Override
	public BankAccount getAccountById(int id) {
		return bankAccountRepo.findById(id).get();
	}

	@Override
	public void deleteAccountById(int id) {
		bankAccountRepo.deleteById(id);
	}

	@Override
	public void updateAccount(BankAccount bankAccount) {
		bankAccountRepo.save(bankAccount);
	}

	@Override
	public List<BankAccount> getAccountsByUserId(int userId) {
		return bankAccountRepo.findByUserId(userId);
	}

	
//	@Override
//	public List<BankAccount> deleteAccounts(int userId) {
//		return bankAccountRepo.removeByUserId(userId);
//		
//	}

}


