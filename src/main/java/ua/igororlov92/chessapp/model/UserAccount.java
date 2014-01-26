package ua.igororlov92.chessapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import ua.igororlov92.chessapp.model.base.BaseEntity;

@Entity
@Table(name = "user_account", uniqueConstraints = { @UniqueConstraint(columnNames = { "email" }) })
public class UserAccount extends BaseEntity {
	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	private LocalDate birthDate;
	
	@NotNull
	private String email;
	
	// TODO avatar (cloudfile)
	// TODO role enum
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}