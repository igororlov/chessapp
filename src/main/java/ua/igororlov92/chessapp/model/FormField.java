package ua.igororlov92.chessapp.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import ua.igororlov92.chessapp.model.base.BaseEntity;
import ua.igororlov92.chessapp.model.dto.FormFieldDto.FormFieldType;

@Entity
@Table(name = "form_field", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class FormField extends BaseEntity {
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private FormFieldType formFieldType;
	
	@NotNull
	private String name;
	
	@NotNull
	private Boolean required;

	
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

}
