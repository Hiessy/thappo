package org.thappo.api.user.models.request;

import org.thappo.commons.enumeration.UserState;

public class UserRequestDTO
    extends AbstractRequestDTO {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String email;
    private String password;
    private int dob;
    private UserState state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "UserRequestDTO [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", dob="
				+ dob + ", state=" + state + "]";
	}
    
}
