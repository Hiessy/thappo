package org.thappo.api.models.business;

import java.util.List;

import org.thappo.commons.enumeration.AccountState;

public class ServiceDTO {

	private int serviceId;
	private String serviceName;
	private int serviceDuration;
	private AccountState state;
	private SubcategoryDTO subcategory;
	private List<ScheduleDTO> schedules;
	
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
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
	public AccountState getState() {
		return state;
	}
	public void setState(AccountState state) {
		this.state = state;
	}
	public SubcategoryDTO getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(SubcategoryDTO subcategory) {
		this.subcategory = subcategory;
	}
	public List<ScheduleDTO> getSchedules() {
		return schedules;
	}
	public void setSchedules(List<ScheduleDTO> schedules) {
		this.schedules = schedules;
	}
	@Override
	public String toString() {
		return "ServiceDTO [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceDuration=" + serviceDuration + ", state=" + state + ", subcategory=" + subcategory + ", schedules=" + schedules + "]";
	}
	
}
