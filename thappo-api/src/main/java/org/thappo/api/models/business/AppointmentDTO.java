package org.thappo.api.models.business;

import org.thappo.api.models.user.UserDTO;
import org.thappo.commons.enumeration.AppointmentState;

public class AppointmentDTO {

	private int appointmentId;
	private long appointment;
	private AppointmentState appointmentState;
	private UserDTO user;
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public long getAppointment() {
		return appointment;
	}
	public void setAppointment(long appointment) {
		this.appointment = appointment;
	}
	public AppointmentState getAppointmentState() {
		return appointmentState;
	}
	public void setAppointmentState(AppointmentState appointmentState) {
		this.appointmentState = appointmentState;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "AppointmentDTO [appointmentId=" + appointmentId + ", appointment=" + appointment + ", appointmentState=" + appointmentState + ", user=" + user + "]";
	}

}
