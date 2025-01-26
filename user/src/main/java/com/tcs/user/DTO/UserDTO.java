package com.tcs.user.DTO;

import java.util.List;

public class UserDTO {
    private int id;
    private String name;
    private String address;
    private List<BankAccountDTO> bankAccounts;
    
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String name, String address, List<BankAccountDTO> bankAccounts) {
		super();
		this.name = name;
		this.address = address;
		this.bankAccounts = bankAccounts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<BankAccountDTO> getBankAccounts() {
		return bankAccounts;
	}

	public void setBankAccounts(List<BankAccountDTO> bankAccounts) {
		this.bankAccounts = bankAccounts;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", address=" + address + ", bankAccounts=" + bankAccounts + "]";
	}
    
    
}
