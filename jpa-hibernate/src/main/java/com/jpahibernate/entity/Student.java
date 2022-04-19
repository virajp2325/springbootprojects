package com.jpahibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "viraj_student")
public class Student {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@Embedded
	private Address address;

	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;

	@ManyToMany
	@JoinTable(name = "viraj_student_courses", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses = new ArrayList<>();

	protected Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
}
