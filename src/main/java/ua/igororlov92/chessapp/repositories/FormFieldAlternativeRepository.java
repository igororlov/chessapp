package ua.igororlov92.chessapp.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.igororlov92.chessapp.model.FormField;
import ua.igororlov92.chessapp.model.FormFieldAlternative;

public interface FormFieldAlternativeRepository extends JpaRepository<FormFieldAlternative, Long> {
	
	Set<FormFieldAlternative> findByFormField(FormField formField);
}
