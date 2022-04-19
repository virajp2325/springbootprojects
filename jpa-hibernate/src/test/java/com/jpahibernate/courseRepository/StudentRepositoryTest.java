package com.jpahibernate.courseRepository;

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
import com.jpahibernate.entity.Address;
import com.jpahibernate.entity.Course;
import com.jpahibernate.entity.Passport;
import com.jpahibernate.entity.Student;

@SpringBootTest(classes = JpaHibernateApplication.class)
class StudentRepositoryTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	/*
	 * @Test public void findById_basic() { Course course =
	 * repository.findById(93l); assertEquals("microservices in 100 steps",
	 * course.getName()); }
	 */

	/*
	 * @Test
	 * 
	 * @DirtiesContext public void deleteById_basic() { repository.deleteById(94l);
	 * assertNull(repository.findById(94l)); }
	 */

	/*
	 * @Test
	 * 
	 * @DirtiesContext public void save_basic() {
	 * 
	 * // get course Course course = repository.findById(100l);
	 * assertEquals("microservice in 100 steps", course.getName());
	 * 
	 * // update details course.setName("BCA - updated"); repository.save(course);
	 * 
	 * // check the value Course course1 = repository.findById(100l);
	 * assertEquals("BCA - updated", course1.getName()); }
	 * 
	 * @Test public void someTest() {
	 * repository.someOprationToUnderstandPersistenceContext(); }
	 */

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = em.find(Student.class, 201l);
		System.out.println("Student -> {}" + student);
		System.out.println("Passport -> {}" + student.getPassport());
	}
	
	@Test
	@Transactional
	public void setAddressDetails() {
		Student student = em.find(Student.class, 201l);
		student.setAddress(new Address("No.105", "Some Street", "Mumbai"));
		System.out.println("Student -> {}" + student);
		//System.out.println("Passport -> {}" + student.getPassport());
	}

	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class, 301l);
		System.out.println("Passport -> {}" + passport);
		System.out.println("Passport -> {}" + passport.getStudent());
	}

}
