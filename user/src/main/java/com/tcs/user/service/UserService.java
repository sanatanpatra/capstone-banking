package com.tcs.user.service;

import java.util.List;

import com.tcs.user.DTO.BankAccountDTO;
import com.tcs.user.DTO.UserDTO;
import com.tcs.user.entity.User;

public interface UserService {
	
	void saveUser(UserDTO userDto);
	List<User> findAll();
    UserDTO getUserAccountDetails(int id);
    User getUserById(int id);
    void updateBankAccount(BankAccountDTO accountDTO);
    void deleteUserAndAccount(int id);
	void updateUserAndBank(UserDTO userDTO);
}

