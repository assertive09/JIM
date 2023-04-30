package com.jim.model;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int sId;

    private String name;
    
    private String email;

    private String password;

    @Column(name = "mobile_number")
    private String mobileNumber;

    private String address;
    
    @ManyToMany(targetEntity = Event.class,cascade = CascadeType.ALL)
    private List<Event> events;

	public Student() {
		super();
	}

	public Student(int sId, String name, String email, String password, String mobileNumber, String address,
			List<Event> events) {
		super();
		this.sId = sId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.events = events;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	    
}
