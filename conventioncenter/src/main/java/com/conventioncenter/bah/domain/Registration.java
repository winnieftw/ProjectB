package com.conventioncenter.bah.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="REGISTRATIONS")
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	int event_id;
	int customer_id;
	
	@Column(name="REGISTRATION_DATE")
	Date date;
	String notes;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}
	
	public Registration(Long id, int event_id, int customer_id, Date date, String notes) {
		super();
		this.id = id;
		this.event_id = event_id;
		this.customer_id = customer_id;
		this.date = date;
		this.notes = notes;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getEvent_id() {
		return event_id;
	}
	public void setEvent_id(int event_id) {
		this.event_id = event_id;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
