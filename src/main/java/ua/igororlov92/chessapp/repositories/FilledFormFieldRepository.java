package ua.igororlov92.chessapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.igororlov92.chessapp.model.FilledFormField;

public interface FilledFormFieldRepository extends JpaRepository<FilledFormField, Long> { 
	
}
