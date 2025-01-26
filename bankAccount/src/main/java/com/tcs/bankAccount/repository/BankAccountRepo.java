package com.tcs.bankAccount.repository;

import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.bankAccount.entity.BankAccount;

@Repository
public interface BankAccountRepo extends JpaRepository<BankAccount, Integer> {
	
	List<BankAccount> findByUserId(int userId);
//	List<BankAccount> deleteByUserId(int userId);

}
