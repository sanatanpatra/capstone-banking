package com.tcs.user.service.Impl;

import java.util.Arrays;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.user.DTO.BankAccountDTO;
import com.tcs.user.DTO.UserDTO;
import com.tcs.user.entity.User;
import com.tcs.user.repository.UserRepo;
import com.tcs.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	RestTemplate restTemplate;

	private static final String url = "http://localhost:9090/bank";

	@Override
	public void saveUser(UserDTO userDTO) {
		User user = new User();
		user.setName(userDTO.getName());
		user.setAddress(userDTO.getAddress());
		user = userRepo.save(user);

		if (userDTO.getBankAccounts() != null && !userDTO.getBankAccounts().isEmpty()) {
			for (BankAccountDTO bankAccountDTO : userDTO.getBankAccounts()) {
				bankAccountDTO.setUserId(user.getId());
				System.out.println(bankAccountDTO);
				restTemplate.postForEntity(url, bankAccountDTO, BankAccountDTO.class);
			}
		}
	}

	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}

	@Override
	public UserDTO getUserAccountDetails(int userId) {
		User user = userRepo.findById(userId).get();
		
		ResponseEntity<List<BankAccountDTO>> response = restTemplate.exchange(url + "/user/" + userId, HttpMethod.GET,null, new ParameterizedTypeReference<List<BankAccountDTO>>() {});
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setAddress(user.getAddress());
		userDTO.setBankAccounts(response.getBody());
		return userDTO;
	}

	@Override
	public void updateBankAccount(BankAccountDTO accountDTO) {
		System.out.println(accountDTO);
		restTemplate.put(url, accountDTO, BankAccountDTO.class);
	}

	@Override
	public void updateUserAndBank(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setAddress(userDTO.getAddress());
		user.setName(userDTO.getName());
		user = userRepo.save(user); // this should update the user

		if (userDTO.getBankAccounts() != null && !userDTO.getBankAccounts().isEmpty()) {
			for (BankAccountDTO bankAccountDTO : userDTO.getBankAccounts()) {
//       		 bankAccountDTO.setUserId(user.getId());
				ResponseEntity<BankAccountDTO> resp = restTemplate.getForEntity(url + "/" + bankAccountDTO.getId(),
						BankAccountDTO.class);
				if (resp != null && resp.getBody() != null) {
					// update
					restTemplate.put(url, bankAccountDTO, BankAccountDTO.class);

				} else {
					// insert
					bankAccountDTO.setUserId(user.getId());
					restTemplate.postForEntity(url, bankAccountDTO, BankAccountDTO.class);

				}
			}
		}

	}

	
	// TODO : Method needs to be updated - to call deletebyId........
	@Override
	public void deleteUserAndAccount(int id) {
		BankAccountDTO[] bankAccountDTO= restTemplate.getForObject(url + "/user/" + id, BankAccountDTO[].class);
		List<BankAccountDTO> bankDTO=Arrays.asList(bankAccountDTO);
		
		if(bankDTO.size()>0)
			for(BankAccountDTO bankdto: bankDTO) {
				restTemplate.delete(url + "/" + bankdto.getId());
				System.out.print(bankdto.getId());
			}
		
		userRepo.deleteById(id);
		
	}

	@Override
	public User getUserById(int userId) {
		return userRepo.findById(userId).get();
	}

}

//orElseThrow(() -> new RuntimeException("User not found"));
//	@Override
//	public void saveUser(User user) {
//		userRepo.save(user);
//		String url="http://localhost:9090/bank";
//		BankAccountDTO bankDTO=new BankAccountDTO(user.getAccountNumber(),user.getAccountType(), user.getUserId());
//		ResponseEntity<BankAccountDTO> resp=restTemplate.postForEntity(url, bankDTO, BankAccountDTO.class);
//		System.out.println(resp);
//		if(resp.getStatusCode()==HttpStatus.OK) {
//			userRepo.save(user);
//		}
//		
//		else
//		{
//			System.out.println("Failed to Connect.....");
//		}
//	}
//
//	@Override
//	public List<User> findAll() {
//		String url="http://localhost:9090/bank";
//		BankAccountDTO[] bankDTO= restTemplate.getForObject(url, BankAccountDTO[].class);
//		for(BankAccountDTO bank:bankDTO) {
//			System.out.println(bank.toString());
//		}
//		return userRepo.findAll();
//	}
//
//	@Override
//	public User findById(int id) {
//		return userRepo.findById(id).get();
//	}
//
//	@Override
//	public void deleteByUserId(int userId) {
//		String url="http://localhost:9090/bank";
////		+String.valueOf(userId);
//		restTemplate.delete(url,userId);
////		userRepo.deleteByUserId(userId);
//	}
//
//	@Override
//	public List<BankAccountDTO> getUserAccounts(int id) {
//		String url="http://localhost:9090/bank/"+String.valueOf(id);
//		System.out.println(url);
//		BankAccountDTO[] bankDTO= restTemplate.getForObject(url, BankAccountDTO[].class);
//		List<BankAccountDTO> l = new ArrayList<>();
//		for(BankAccountDTO bank:bankDTO) {
////			System.out.println(bank.toString());
//			l.add(bank);
//		}
//		return l;
//		
//	}
