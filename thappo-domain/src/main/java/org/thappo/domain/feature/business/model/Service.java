package org.thappo.domain.feature.business.model;

import java.util.ArrayList;
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
@Table(name = "services")
public class Service {

	@Id
	@Column(name = "service_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer service_id;

	@Column(name = "service_name")
	private String serviceName;

	@Column(name = "service_duration")
	private int serviceDuration;
	
	@Column(name = "state")
	private String state;
	
	@OneToOne
	@JoinColumn(name = "subcategory_id")
	private SubCategory subCategory;

	@ManyToOne
	@JoinColumn(name = "branch_id")
	private Branch branch;

	@OneToMany(mappedBy="service")
	private List<Schedule> schedules = new ArrayList<Schedule>();

	public Integer getService_id() {
		return service_id;
	}

	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public int getServiceDuration() {
		return serviceDuration;
	}

	public void setServiceDuration(int serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	@Override
	public String toString() {
		return "Service [service_id=" + service_id + ", serviceName=" + serviceName + ", serviceDuration="
				+ serviceDuration + ", state=" + state + ", subCategory=" + subCategory + ", branch=" + branch
				+ ", schedules=" + schedules + "]";
	}

}
