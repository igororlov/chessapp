package ua.igororlov92.chessapp.model.dto.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ua.igororlov92.chessapp.model.FormField;
import ua.igororlov92.chessapp.model.dto.FormFieldDto.CreateFormFieldDto;
import ua.igororlov92.chessapp.model.dto.FormFieldDto.ReadFormFieldDto;

@Service
public class FormFieldHelper {

	private static final Logger logger = LoggerFactory.getLogger(FormFieldHelper.class);
	
	public FormField toEntity(CreateFormFieldDto dto) {
		logger.warn("toEntity not implemented yet");
		return new FormField();
	}
	
	public ReadFormFieldDto toDto(FormField entity) {
		
		ReadFormFieldDto dto = new ReadFormFieldDto();
		dto.id = entity.getId();
		dto.formFieldType = entity.getFormFieldType();
		dto.name = entity.getName();
		dto.required = entity.getRequired();
		
		return dto;
	}
	
}
