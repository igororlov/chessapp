package ua.igororlov92.chessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.igororlov92.chessapp.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> { 
	
}
