package org.thappo.domain.feature.user.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.thappo.commons.enumeration.Profile;
import org.thappo.commons.enumeration.UserState;
import org.thappo.domain.feature.commons.model.AbstractDomain;

public class UserDomain
    extends AbstractDomain {

    private static final long serialVersionUID = 1L;

    public interface AddValidations {
    }

    public interface UpdateValidations {
    }

    private String id;

    @NotNull(groups = {AddValidations.class}, message = "Name must not be null")
    @Size(min = 2, max = 20, groups = {AddValidations.class, UpdateValidations.class}, message = "Name must be between {min} and {max} chars")
    private String firstName;

    @NotNull(groups = {AddValidations.class}, message = "Name must not be null")
    @Size(min = 2, max = 20, groups = {AddValidations.class, UpdateValidations.class}, message = "Name must be between {min} and {max} chars")
	private String lastName;
	
    @NotNull(groups = {AddValidations.class}, message = "Name must not be null")
    @Size(min = 5, max = 50, groups = {AddValidations.class, UpdateValidations.class}, message = "Name must be between {min} and {max} chars")
	private String email;
	
    @NotNull(groups = {AddValidations.class}, message = "Name must not be null")
    @Size(min = 6, max = 40, groups = {AddValidations.class, UpdateValidations.class}, message = "Name must be between {min} and {max} chars")
	private String password;
    
    @NotNull(groups = {AddValidations.class}, message = "Gender must not be null")
	private Profile profile;
	
    @NotNull(groups = {AddValidations.class}, message = "Type must not be null")
    private UserState state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserDomain [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", profile=" + profile + ", state=" + state + "]";
	}

}
