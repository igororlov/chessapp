package ua.igororlov92.chessapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import ua.igororlov92.chessapp.model.base.BaseEntity;

@Entity
public class FormFieldAlternative extends BaseEntity {
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private FormField formField;
	
	@NotNull
	private String name;

	public FormField getFormField() {
		return formField;
	}

	public void setFormField(FormField formField) {
		this.formField = formField;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
