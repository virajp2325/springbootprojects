package com.jpahibernate.courseRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.jpahibernate.JpaHibernateApplication;
import com.jpahibernate.entity.Course;
import com.jpahibernate.entity.Review;
import com.jpahibernate.entity.Student;

@SpringBootTest(classes = JpaHibernateApplication.class)
class CourseRepositoryTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager em;
	/*
	 * @Test public void findById_basic() { Course course =
	 * repository.findById(93l); assertEquals("microservices in 100 steps",
	 * course.getName()); }
	 */

	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.deleteById(38l);
		assertNull(repository.findById(38l));
	}

	/*
	 * @Test
	 * 
	 * @DirtiesContext public void save_basic() {
	 * 
	 * // get course Course course = repository.findById(100l);
	 * assertEquals("microservices in 100 steps", course.getName());
	 * 
	 * // update details course.setName("BCA - updated"); repository.save(course);
	 * 
	 * // check the value Course course1 = repository.findById(100l);
	 * assertEquals("BCA - updated", course1.getName()); }
	 */

	/*
	 * @Test
	 * 
	 * @DirtiesContext public void playWithEntityManager() {
	 * repository.playWithEntityManager(); }
	 * 
	 * @Test
	 * 
	 * @Transactional public void retriveReviewsForCourse() { Course course =
	 * repository.findById(103l); System.out.println("Course.getReviews -> {}" +
	 * course.getReviews()); }
	 * 
	 * @Test
	 * 
	 * @Transactional public void retriveReviewsForReview() { Review review =
	 * em.find(Review.class, 103l); System.out.println("Review.getCourse -> {}" +
	 * review.getCourse()); }
	 * 
	 * @Test
	 * 
	 * @Transactional public void retriveStudentAndCourse() { Student student =
	 * em.find(Student.class, 201l); System.out.println("Student -> {}" + student);
	 * System.out.println("Course -> {}" + student.getCourses()); }
	 * 
	 * @Test public void findBy_firstLevelCacheDemo() { Course course =
	 * repository.findById(102l); System.out.println("First Course Retrived {}" +
	 * course);
	 * 
	 * Course course1 = repository.findById(102l);
	 * System.out.println("First Course Retrive again {}" + course1);
	 * 
	 * 
	 * assertEquals("JPA in 50 Steps" + course.getName());
	 * assertEquals("JPA in 50 Steps"+ course1.getName());
	 * 
	 * }
	 */

}
