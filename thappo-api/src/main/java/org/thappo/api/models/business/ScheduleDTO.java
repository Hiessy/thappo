package org.thappo.api.models.business;

import java.util.List;

import org.thappo.api.models.user.UserDTO;

public class ScheduleDTO {
	
	private int scheduleId;
	private String sunday;
	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private UserDTO user;
	private List<AppointmentDTO> appointments;
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
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
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public List<AppointmentDTO> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<AppointmentDTO> appointments) {
		this.appointments = appointments;
	}
	@Override
	public String toString() {
		return "ScheduleDTO [scheduleId=" + scheduleId + ", sunday=" + sunday + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday=" + wednesday + ", thursday=" + thursday + ", friday=" + friday + ", user=" + user + ", appointments=" + appointments + "]";
	} 

}
