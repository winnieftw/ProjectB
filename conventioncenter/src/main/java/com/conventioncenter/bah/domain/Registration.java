package com.conventioncenter.bah.domain;

public class Registration {
	Long id;
	int event_id;
	int customer_id;
	String date;
	String notes;
	
	
	
	public Registration(Long id, int event_id, int customer_id, String date, String notes) {
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	

}
