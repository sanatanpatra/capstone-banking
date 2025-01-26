package com.tcs.bankAccount.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bankAccount.entity.BankAccount;
import com.tcs.bankAccount.service.BankAccountService;

@RestController
public class BankAccountController {
	
	@Autowired
	BankAccountService bankAccountService;
	
	@PostMapping("/bank")
	void createAccount(@RequestBody BankAccount bankAccount)
	{
		bankAccountService.createAccount(bankAccount);
		System.out.println(bankAccount.toString());
	}
	
	
	@GetMapping("/bank/user/{userId}")
	List<BankAccount> getAccountsByUserId(@PathVariable int userId )
	{
		return bankAccountService.getAccountsByUserId(userId);
	}
	
	@GetMapping("/bank/{id}")
	BankAccount getAccountById(@PathVariable int id)
	{
		return bankAccountService.getAccountById(id);
	}
	
	@PutMapping("/bank")
	void updateAccount(@RequestBody BankAccount bankAccount)
	{
		bankAccountService.updateAccount(bankAccount);
	}
	
	@DeleteMapping("/bank/{id}")
	void deleteAccountById(@PathVariable int id)
	{
		bankAccountService.deleteAccountById(id);
	}
	
//	@DeleteMapping("/bank/user/{userId}")
//	void deleteAccounts(@PathVariable int userId)
//	{
//		System.out.println("--- In bank Controller - before delete");
//		bankAccountService.deleteAccounts(userId);
//	}

}
