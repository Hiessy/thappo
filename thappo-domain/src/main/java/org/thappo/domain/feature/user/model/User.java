package org.thappo.domain.feature.user.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.thappo.commons.enumeration.Profile;
import org.thappo.commons.enumeration.UserState;
import org.thappo.domain.feature.commons.model.AbstractEntity;
import org.thappo.domain.feature.contact.model.Contact;

@Entity
@Table(name = "users")
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
	private UserState state;
	
	@OneToMany(
	        mappedBy = "user", 
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
	private List<Contact> contacts = new ArrayList<Contact>();


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

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

    public void addContact(Contact contact) {
    	contacts.add(contact);
    	contact.setUser(this);
    }
 
    public void removeContact(Contact contact) {
    	contacts.remove(contact);
    	contact.setUser(null);
    }
	       
	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", profile=" + profile + ", state=" + state + "]";
	}


}
