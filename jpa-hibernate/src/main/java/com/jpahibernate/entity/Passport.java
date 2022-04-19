package com.jpahibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "viraj_passport")
public class Passport {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
	private String number;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	private Student student;

	protected Passport() {
	}

	public Passport(String number) {
		super();
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Passport [name=" + number + "]";
	}
}
