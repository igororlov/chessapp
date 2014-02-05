package ua.igororlov92.chessapp.model.dto;

import java.util.List;

import org.joda.time.DateTime;

import ua.igororlov92.chessapp.model.dto.FormFieldDto.ReadFormFieldDto;

public abstract class EventDto {

	public String name;
	
	public String description;
	
	public String place;
	
	public Long createdByUserAccountId;
	
	public DateTime createdTime;
	
	public DateTime deadlineTime;
	
	public DateTime startTime;
	
	public DateTime endTime;
	
	public List<ReadFormFieldDto> formFields;
	
	public static class CreateEventDto extends EventDto {
		
	}
	
	public static class ReadEventDto extends EventDto {
		
		public Long id;
		
	}
}
