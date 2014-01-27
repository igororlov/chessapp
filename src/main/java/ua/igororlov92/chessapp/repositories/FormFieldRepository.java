package ua.igororlov92.chessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.igororlov92.chessapp.model.FormField;

public interface FormFieldRepository extends JpaRepository<FormField, Long> {
	
	FormField findByName(String name);
	
}
