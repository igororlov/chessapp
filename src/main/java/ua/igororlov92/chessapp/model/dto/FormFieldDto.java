package ua.igororlov92.chessapp.model.dto;

public abstract class FormFieldDto {
	
	public enum FormFieldType {
		bool,
		string,
		date,
		integer,
		decimal,
		stringAlternative
	}
	
	public FormFieldType formFieldType;
	
	public String name;
	
	public Boolean required;
	
	public static class CreateFormFieldDto extends FormFieldDto {
		
	}
	
	public static class ReadFormFieldDto extends FormFieldDto {
		
		public Long id;
		
	}
	
}
