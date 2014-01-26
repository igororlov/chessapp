package ua.igororlov92.chessapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import ua.igororlov92.chessapp.model.base.BaseEntity;

@Entity
@Table(name = "registration")
public class Registration extends BaseEntity {
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	private Event event;
	
	@NotNull
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime registeredTime;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private UserAccount userAccount;

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
	
	
}
