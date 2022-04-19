package com.jpahibernate.courseRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpahibernate.entity.Course;
import com.jpahibernate.entity.Passport;
import com.jpahibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;

	/*
	 * public Student findById(Long id) { return em.find(Student.class, id); }
	 * 
	 * public void deleteById(Long id) { Student student = findById(id);
	 * em.remove(student); }
	 */

	/*
	 * public Student save(Student student) {
	 * 
	 * if (student.getId() == 0) { em.persist(student); } else { em.merge(student);
	 * }
	 * 
	 * return student; }
	 */
	/*
	 * public void saveStudentWithPassport() { Passport passport = new
	 * Passport("D854655"); em.persist(passport);
	 * 
	 * Student student = new Student("kapil"); student.setPassport(passport);
	 * em.persist(student); }
	 * 
	 * public void someOprationToUnderstandPersistenceContext() { // Retrieve
	 * student Student student = em.find(Student.class, 203l);
	 * 
	 * // Retrieve passport Passport passport = student.getPassport();
	 * 
	 * // update passport passport.setNumber("Y234156");
	 * 
	 * // update student student.setName("kapil - upated"); }
	 */
	/*
	 * em.persist(student1); Student student2 = new
	 * Student("Angular JS in 100 steps"); em.persist(student2); em.flush();
	 * em.clear();
	 * 
	 * student1.setName("Web services in 100 steps - Updated"); em.flush();
	 * student2.setName("Angular JS in 100 steps - Updated"); em.flush();
	 */

	/*
	 * public void insertHardCodedStudentAndCourse() { Student student = new
	 * Student("Prashant"); Course course = new Course("Java in 150 steps");
	 * em.persist(student); em.persist(course);
	 * 
	 * student.addCourse(course); course.addStudents(student); em.persist(student);
	 * 
	 * }
	 */
	
	public void insertStudentAndCourse( Student student, Course course) {
		student.addCourse(course);
		course.addStudents(student);
		
		em.persist(student);
		em.persist(course);
	}
	
}











