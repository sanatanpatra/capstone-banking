package com.tcs.bankAccount.service;

import java.util.List;

import com.tcs.bankAccount.entity.BankAccount;

public interface BankAccountService {
	
	void createAccount(BankAccount bankAccount);
	BankAccount getAccountById(int id);
	void deleteAccountById(int id);
	void updateAccount(BankAccount bankAccount);
	List<BankAccount> getAccountsByUserId(int userId);
//	List<BankAccount> deleteAccounts(int userId);

}
