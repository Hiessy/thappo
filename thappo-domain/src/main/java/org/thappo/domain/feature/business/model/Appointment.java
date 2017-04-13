package org.thappo.domain.feature.business.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.thappo.domain.feature.user.model.User;

@Entity
@Table(name = "appointments")
public class Appointment {

	@Id
	@Column(name = "appointment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer appointmentId;

	@Column(name = "appointment")
	private String appointment;

	@Column(name = "appointment_state")
	private String appointmentState;
		
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "employee_id")
	private User employee;

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getAppointment() {
		return appointment;
	}

	public void setAppointment(String appointment) {
		this.appointment = appointment;
	}

	public String getAppointmentState() {
		return appointmentState;
	}

	public void setAppointmentState(String appointmentState) {
		this.appointmentState = appointmentState;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getEmployee() {
		return employee;
	}

	public void setEmployee(User employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", appointment=" + appointment + ", appointmentState="
				+ appointmentState + ", user=" + user + ", employee=" + employee + "]";
	}
		
}
