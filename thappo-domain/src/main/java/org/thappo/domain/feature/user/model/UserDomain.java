package org.thappo.domain.feature.user.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.thappo.commons.enumeration.Profile;
import org.thappo.commons.enumeration.UserState;
import org.thappo.domain.feature.commons.model.AbstractDomain;
import org.thappo.domain.feature.contact.model.Contact;
import org.thappo.domain.feature.contact.model.ContactDomain;

public class UserDomain
    extends AbstractDomain {

    private static final long serialVersionUID = 1L;

    public interface AddValidations {
    }

    public interface UpdateValidations {
    }

    private Integer userId;

    @NotNull(groups = {AddValidations.class}, message = "Name must not be null")
    @Size(min = 2, max = 20, groups = {AddValidations.class, UpdateValidations.class}, message = "First name must be between {min} and {max} chars")
    private String firstName;

    @NotNull(groups = {AddValidations.class}, message = "Name must not be null")
    @Size(min = 2, max = 20, groups = {AddValidations.class, UpdateValidations.class}, message = "Last name must be between {min} and {max} chars")
	private String lastName;
	
    @NotNull(groups = {AddValidations.class}, message = "Name must not be null")
    @Size(min = 5, max = 50, groups = {AddValidations.class, UpdateValidations.class}, message = "Email must be between {min} and {max} chars")
    @Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", groups = {AddValidations.class, UpdateValidations.class}, message = "Email must conform to top level domain standards")
    private String email;
	
    @NotNull(groups = {AddValidations.class}, message = "Name must not be null")
    @Size(min = 6, max = 40, groups = {AddValidations.class, UpdateValidations.class}, message = "Password must be between {min} and {max} chars")
    private String password;
    
    @Digits(fraction = 0, integer = 8, groups = {AddValidations.class, UpdateValidations.class}, message = "Date of birth must be between {min} and {max} chars")
    private Integer dob;
    
    @NotNull(groups = {AddValidations.class}, message = "Profile must not be null")
	private Profile profile;
	
    @NotNull(groups = {AddValidations.class}, message = "State must not be null")
    private UserState state;
    
    private List<ContactDomain> contactsDomain = new ArrayList<ContactDomain>();
    		

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

	public Integer getDob() {
		return dob;
	}

	public void setDob(Integer dob) {
		this.dob = dob;
	}

	public List<ContactDomain> getContactsDomain() {
		return contactsDomain;
	}

	public void setContactsDomain(List<ContactDomain> contactsDomain) {
		this.contactsDomain = contactsDomain;
	}
	
    public void addContact(ContactDomain contact) {
    	contactsDomain.add(contact);
    	contact.setUser(this);
    }
 
    public void removeContact(ContactDomain contact) {
    	contactsDomain.remove(contact);
    	contact.setUser(null);
    }

	@Override
	public String toString() {
		return "UserDomain [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", dob=" + dob + ", profile=" + profile + ", state=" + state + ", contactsDomain=" + contactsDomain + "]";
	}	

}
