package ua.igororlov92.chessapp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import ua.igororlov92.chessapp.model.base.BaseEntity;

@Entity
@Table(name = "registration")
public class Registration extends BaseEntity {
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Event event;
	
	@NotNull
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime registeredTime;
	
	@NotNull
	private String fullName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UserAccount userAccount;

	@OneToMany(mappedBy = "registration")
	private Set<FilledFormField> filledFormFields;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private EventGroup eventGroup;
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public DateTime getRegisteredTime() {
		return registeredTime;
	}

	public void setRegisteredTime(DateTime registeredTime) {
		this.registeredTime = registeredTime;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Set<FilledFormField> getFilledFormFields() {
		return filledFormFields;
	}

	public void setFilledFormFields(Set<FilledFormField> filledFormFields) {
		this.filledFormFields = filledFormFields;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public EventGroup getEventGroup() {
		return eventGroup;
	}

	public void setEventGroup(EventGroup eventGroup) {
		this.eventGroup = eventGroup;
	}

}
