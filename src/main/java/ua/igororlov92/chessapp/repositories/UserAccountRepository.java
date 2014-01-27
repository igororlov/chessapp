package ua.igororlov92.chessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.igororlov92.chessapp.model.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
	
	UserAccount findByEmail(String email);
	
}
