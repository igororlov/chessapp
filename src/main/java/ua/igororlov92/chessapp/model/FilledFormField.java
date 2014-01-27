package ua.igororlov92.chessapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import ua.igororlov92.chessapp.model.base.BaseEntity;

@Entity
public class FilledFormField extends BaseEntity {
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Registration registration;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private FormField formField;

	@NotNull
	private String value;
	
	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public FormField getFormField() {
		return formField;
	}

	public void setFormField(FormField formField) {
		this.formField = formField;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
