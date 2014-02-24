package ua.igororlov92.chessapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import ua.igororlov92.chessapp.model.base.BaseEntity;

@Entity
@Table(name = "group", uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class Group extends BaseEntity {
	
	@NotNull
	@ManyToOne
	private Event event;

	@NotBlank
	private String name;
	
	@OneToMany
	private Set<Registration> registrations;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	} 

	
}
