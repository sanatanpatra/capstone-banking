package com.tcs.bankAccount.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bank_account")
public class BankAccount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id; 
	
	@Column(name="account_number")
	private String accountNumber;
	
	@Column(name="account_type")
	private String accountType;
	
	@Column(name="user_id")
	private int userId ;

	public BankAccount() {
		super();
	}

	public BankAccount(String accountNumber, String accountType, int userId) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BankAccount [id=" + id + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", userId=" + userId + "]";
	}
	

}
