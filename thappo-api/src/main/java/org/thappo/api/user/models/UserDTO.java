package org.thappo.api.user.models;

import org.thappo.commons.enumeration.Profile;
import org.thappo.commons.enumeration.UserState;

public class UserDTO extends AbstractDTO {

    private static final long serialVersionUID = 1L;

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int dob;
    private Profile profile;
    private UserState state;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getDob() {
		return dob;
	}
	public void setDob(int dob) {
		this.dob = dob;
	}
	public UserState getState() {
		return state;
	}
	public void setState(UserState state) {
		this.state = state;
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
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", profile=" + profile + ", state=" + state + "]";
	}
}
