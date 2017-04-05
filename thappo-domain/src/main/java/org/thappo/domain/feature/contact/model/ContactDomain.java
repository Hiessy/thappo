package org.thappo.domain.feature.contact.model;

import org.thappo.domain.feature.user.model.User;
import org.thappo.domain.feature.user.model.UserDomain;

public class ContactDomain {

	private Integer contactId;
	private String cellphone;
	private String telephone;
	private String address;
	private UserDomain userDomain;

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserDomain getUser() {
		return userDomain;
	}

	public void setUser(UserDomain userDomain) {
		this.userDomain = userDomain;
	}

	@Override
	public String toString() {
		return "ContactDomain [contactId=" + contactId + ", cellphone=" + cellphone + ", telephone=" + telephone + ", address=" + address + ", userDomain=" + userDomain + "]";
	}

}
