package com.jpahibernate.courseRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpahibernate.entity.Course;
import com.jpahibernate.entity.Review;
import com.jpahibernate.entity.ReviewRating;

import ch.qos.logback.classic.Logger;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	public Course findById(Long id) {
		return em.find(Course.class, id);
	}

	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}

	public Course save(Course course) {

		if (course.getId() == 0) {
			em.persist(course);
		} else {
			em.merge(course);
		}

		return course;
	}

	public void playWithEntityManager() {
		Course course1 = new Course("Web services in 100 steps");
		em.persist(course1);
		Course course2 = new Course("Abgular js in 100 steps");
		em.persist(course2);
		em.flush();
		em.clear();

		course1.setName("Web services in 100 steps - Updated");
		em.flush();
		course2.setName("Angular js in 100 steps - Updated");
		em.flush();
	}

	public void addHardCodedReviewsForCourse() {
		// get the course 103
		Course course = em.find(Course.class,116l);
		System.out.println("Course.getReviews() -> {}" + course.getReviews());

		// add 2 reviews to it
		Review review1 = new Review(ReviewRating.FIVE, "Greate Hands-on Stuff");
		Review review2 = new Review(ReviewRating.FIVE, "Good");

		course.addReview(review1);
		review1.setCourse(course);

		course.addReview(review2);
		review2.setCourse(course);

		// save it to the database
		em.persist(review1);
		em.persist(review2);
	
	}

	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		System.out.println("Course.getReviews() -> {}" + course.getReviews());

		for (Review review : reviews) {
			// Setting the relationship
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}

	}

}
