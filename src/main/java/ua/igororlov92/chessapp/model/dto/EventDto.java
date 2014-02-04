package ua.igororlov92.chessapp.model.dto;

public abstract class EventDto {

	public String name;
	
	public String description;
	
	public static class CreateEventDto extends EventDto {
		
	}
	
	public static class ReadEventDto extends EventDto {
		
		public Long id;
		
	}
}
