package com.jim.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int eId;
	
	private String name;
	
	private String description;
	
	@DateTimeFormat(pattern ="yyyy-MM-dd'T'HH:mm")
	private Date date_time;
	
	@ManyToMany(cascade = CascadeType.ALL ,targetEntity = Student.class)
	private List<Student> students;

	
	
	public Event() {
		super();
	}

	public Event(int eId, String name, String description, Date date_time, List<Student> students) {
		super();
		this.eId = eId;
		this.name = name;
		this.description = description;
		this.date_time = date_time;
		this.students = students;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate_time() {
		return date_time;
	}

	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Event [eId=" + eId + ", name=" + name + ", description=" + description + ", date_time=" + date_time
				+ ", students=" + students + "]";
	}	
}
