package org.thappo.domain.feature.business.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "branches")
public class Branch {

	@Id
	@Column(name = "branch_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer branchId;

	@Column(name = "telephone")
	private String telephone;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "business_id")
	private Business business;
	
	@OneToMany(mappedBy="branch")
	private List<Service> services;

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", telephone=" + telephone + ", address=" + address + ", business="
				+ business + ", services=" + services + "]";
	}

}
