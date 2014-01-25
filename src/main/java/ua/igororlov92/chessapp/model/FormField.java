package ua.igororlov92.chessapp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import ua.igororlov92.chessapp.model.base.BaseEntity;

public class FormField extends BaseEntity {
	
	public enum FormFieldType {
		bool,
		string,
		date,
		integer,
		decimal,
		stringAlternative
	}
	
	@NotNull
	private FormFieldType formFieldType;
	
	@NotNull
	private String name;
	
	@NotNull
	private Boolean required;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "formFields")
	private Set<Event> events = new HashSet<Event>(0);
	
	public FormFieldType getFormFieldType() {
		return formFieldType;
	}

	public void setFormFieldType(FormFieldType formFieldType) {
		this.formFieldType = formFieldType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
}
