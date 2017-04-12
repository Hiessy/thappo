package org.thappo.api.models.business;

import java.util.List;

import org.thappo.api.models.generics.AddressDTO;

public class BranchDTO {
	
	private int branchId;
	private String telephone;
	private String email;
	private AddressDTO address;
	private List<ServiceDTO> services;
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	public List<ServiceDTO> getServices() {
		return services;
	}
	public void setServices(List<ServiceDTO> services) {
		this.services = services;
	}
	@Override
	public String toString() {
		return "BranchDTO [branchId=" + branchId + ", telephone=" + telephone + ", email=" + email + ", address=" + address + ", services=" + services + "]";
	}

}
