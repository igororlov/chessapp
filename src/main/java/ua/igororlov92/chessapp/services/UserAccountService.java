package ua.igororlov92.chessapp.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import ua.igororlov92.chessapp.model.UserAccount;
import ua.igororlov92.chessapp.repositories.UserAccountRepository;

@Service
public class UserAccountService {
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(UserAccountService.class);
	
	public List<UserAccount> testGetUserAccounts() {
		
		List<UserAccount> userAccounts = new ArrayList<UserAccount>();
		for (UserAccount userAccount : userAccountRepository.findAll()) {
			userAccounts.add(userAccount);
		}
		return userAccounts;
	}
	
	public static String encryptPassword(String unencryptedPassword) {
		return new ShaPasswordEncoder(256).encodePassword(unencryptedPassword, "");
	}
}
