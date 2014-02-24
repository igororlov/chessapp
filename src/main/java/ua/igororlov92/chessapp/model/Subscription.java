package ua.igororlov92.chessapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import ua.igororlov92.chessapp.model.base.BaseEntity;

@Entity
@Table(name = "subscription", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }), @UniqueConstraint(columnNames = { "unsubscribeLink" }) })
public class Subscription extends BaseEntity {
		
	@NotNull
	private String email;

	@NotNull
	private String subscriberFirstName;
	
	@NotNull
	private String subscriberLastName;
	
	@NotNull
	private String unsubscribeLink;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubscriberFirstName() {
		return subscriberFirstName;
	}

	public void setSubscriberFirstName(String subscriberFirstName) {
		this.subscriberFirstName = subscriberFirstName;
	}

	public String getSubscriberLastName() {
		return subscriberLastName;
	}

	public void setSubscriberLastName(String subscriberLastName) {
		this.subscriberLastName = subscriberLastName;
	}

	public String getUnsubscribeLink() {
		return unsubscribeLink;
	}

	public void setUnsubscribeLink(String unsubscribeLink) {
		this.unsubscribeLink = unsubscribeLink;
	}
	
	
}
