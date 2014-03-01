package ua.igororlov92.chessapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import ua.igororlov92.chessapp.model.base.BaseEntity;

@Entity
@Table(name = "event_group",  uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
public class EventGroup extends BaseEntity {
	
	@NotNull
	private String name;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Event event;
	
	@OneToMany(mappedBy = "eventGroup", fetch = FetchType.LAZY)
	private Set<Registration> registrations;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}
	
}
