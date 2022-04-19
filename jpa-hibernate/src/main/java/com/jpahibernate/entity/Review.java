package com.jpahibernate.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "viraj_review")
public class Review {

	@Id
	@GeneratedValue
	private long id;

	@Enumerated(EnumType.STRING)
	private ReviewRating rating;

	private String discription;

	@ManyToOne
	private Course course;

	protected Review() {
	}

	public Review(ReviewRating rating, String discription) {
		this.rating = rating;
		this.discription = discription;
	}

	public ReviewRating getRating() {
		return rating;
	}

	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Review [rating=" + rating + ", discription=" + discription + "]";
	}

}
