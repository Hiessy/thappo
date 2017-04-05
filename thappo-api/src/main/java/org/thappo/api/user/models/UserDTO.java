package org.thappo.api.user.models;

import java.util.ArrayList;
import java.util.List;

import org.thappo.commons.enumeration.Profile;
import org.thappo.commons.enumeration.UserState;

public class UserDTO extends AbstractDTO {

    private static final long serialVersionUID = 1L;

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Integer dob;
    private Profile profile;
    private UserState state;
    private List<ContactDTO> contactsDTO = new ArrayList<ContactDTO>();
    
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public List<ContactDTO> getContactsDTO() {
		return contactsDTO;
	}
	public void setContactsDTO(List<ContactDTO> contactsDTO) {
		this.contactsDTO = contactsDTO;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", dob=" + dob + ", profile=" + profile + ", state=" + state + ", contactsDTO=" + contactsDTO + "]";
	}

}
