package ua.igororlov92.chessapp.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.igororlov92.chessapp.model.FormField;
import ua.igororlov92.chessapp.model.dto.FormFieldDto.ReadFormFieldDto;
import ua.igororlov92.chessapp.repositories.FormFieldRepository;

@Controller
@RequestMapping("/formFieldsApi")
public class FormFieldAPIController {

	@Autowired
	private FormFieldRepository formFieldRepository;

	private static final Logger logger = LoggerFactory.getLogger(FormFieldAPIController.class);
	
	@RequestMapping(value="/getAllAsDto", method = RequestMethod.GET)
	public @ResponseBody List<ReadFormFieldDto> getAllAsDto() {
 
		List<FormField> formFields = formFieldRepository.findAll();
		List<ReadFormFieldDto> formFieldDtos = new ArrayList<>();
		
		for (FormField formField : formFields) {
			formFieldDtos.add(toDto(formField));
		}
		
		return formFieldDtos;
	}
	
	private ReadFormFieldDto toDto(FormField entity) {
		
		ReadFormFieldDto dto = new ReadFormFieldDto();
		dto.id = entity.getId();
		dto.formFieldType = entity.getFormFieldType();
		dto.name = entity.getName();
		dto.required = entity.getRequired();
		
		return dto;
	}
}
