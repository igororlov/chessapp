package ua.igororlov92.chessapp.model.dto.helpers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.model.FormField;
import ua.igororlov92.chessapp.model.dto.EventDto.CreateEventDto;
import ua.igororlov92.chessapp.model.dto.EventDto.ReadEventDto;
import ua.igororlov92.chessapp.model.dto.FormFieldDto.ReadFormFieldDto;

@Service
public class EventHelper {
	
	@Autowired
	private FormFieldHelper formFieldHelper;
	
	private static final Logger logger = LoggerFactory.getLogger(EventHelper.class);
	
	public Event toEntity(CreateEventDto dto) {
		logger.warn("toEntity not implemented yet");
		return new Event();
	}
	
	public ReadEventDto toDto(Event entity) {
		
		ReadEventDto readEventDto = new ReadEventDto();
		
		readEventDto.name = entity.getName();
		readEventDto.description = entity.getDescription();
		readEventDto.place = entity.getPlace();
		readEventDto.createdTime = entity.getCreatedTime();
		readEventDto.createdByUserAccountId = entity.getCreatedByUserAccount().getId();
		readEventDto.deadlineTime = entity.getDeadlineTime();
		readEventDto.startTime = entity.getStartTime();
		readEventDto.endTime = entity.getEndTime();
		
		List<ReadFormFieldDto> dtos = new ArrayList<>();
		for (FormField formField : entity.getFormFields()) {
			dtos.add(formFieldHelper.toDto(formField));
		}
		readEventDto.formFields = dtos;
		
		return readEventDto;
	}
	
}
