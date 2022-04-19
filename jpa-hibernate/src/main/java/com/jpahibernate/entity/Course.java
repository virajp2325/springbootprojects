package com.jpahibernate.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "viraj_course")
@NamedQuery(name = "Query_get", query = "select c from Course c")
@Cacheable
@SQLDelete(sql="update viraj_course set is_deleted= true where id=?")
@Where(clause = "is_deleted=false")
public class Course {

	@Id
	@GeneratedValue
	private long id;
	private String name;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();

	@ManyToMany(mappedBy = "courses")
	@JsonIgnore
	private List<Student> students = new ArrayList<>();
	
	private boolean isDeleted;
	
	@PreRemove
	private void preRemove() {
		System.out.println("Setting isDeleted to true");
		this.isDeleted =  true;
	}

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student students) {
		this.students.add(students);
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + "]";
	}

	/*
	 * @Override public String toString() { return String.format("Course [%s]",
	 * name); }
	 */
}
