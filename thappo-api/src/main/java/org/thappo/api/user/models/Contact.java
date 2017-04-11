package org.thappo.api.user.models;

public class Contact extends AbstractDTO {

	private static final long serialVersionUID = 1L;

	private Integer contactId;
	private String cellphone;
	private String telephone;
	private String address;

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

	@Override
	public String toString() {
		return "ContactDTO [contactId=" + contactId + ", cellphone=" + cellphone + ", telephone=" + telephone + ", address=" + address + "]";
	}

}
