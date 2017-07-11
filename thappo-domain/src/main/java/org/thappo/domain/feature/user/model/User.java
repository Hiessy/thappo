package org.thappo.domain.feature.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.thappo.commons.enumeration.AccountState;
import org.thappo.commons.enumeration.Profile;
import org.thappo.domain.feature.commons.model.AbstractEntity;

@Entity(name = "users")
public class User extends AbstractEntity {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "dob")
	private Integer dob;

	@Enumerated(EnumType.STRING)
	@Column(name = "profile")
	private Profile profile;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "state")
	private AccountState state;
	
	@Column(name = "telephone")
    private String telephone;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getDob() {
		return dob;
	}

	public void setDob(Integer dob) {
		this.dob = dob;
	}

	public AccountState getState() {
		return state;
	}

	public void setState(AccountState state) {
		this.state = state;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", profile=" + profile + ", state=" + state
				+ ", telephone=" + telephone + "]";
	}

	

}
