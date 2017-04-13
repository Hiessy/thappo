package org.thappo.domain.feature.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.thappo.domain.feature.user.model.User;

@Entity
@Table(name = "schedules")
public class Schedule {

	@Id
	@Column(name = "schedule_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer scheduleId;

	@Column(name = "sunday")
	private String sunday;

	@Column(name = "monday")
	private String monday;
	
	@Column(name = "tuesday")
	private String tuesday;
	
	@Column(name = "wednesday")
	private String wednesday;
	
	@Column(name = "thursday")
	private String thursday;
	
	@Column(name = "friday")
	private String friday;
	
	@Column(name = "saturday")
	private String saturday;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "service_id")
	private Service service;

	public Integer getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId + ", sunday=" + sunday + ", monday=" + monday + ", tuesday="
				+ tuesday + ", wednesday=" + wednesday + ", thursday=" + thursday + ", friday=" + friday + ", saturday="
				+ saturday + ", user=" + user + ", service=" + service + "]";
	}
	
}
