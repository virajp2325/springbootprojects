package com.jpahibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpahibernate.courseRepository.CourseRepository;
import com.jpahibernate.courseRepository.EmployeeRepository;
import com.jpahibernate.courseRepository.StudentRepository;
import com.jpahibernate.entity.Course;
import com.jpahibernate.entity.FullTimeEmployee;
import com.jpahibernate.entity.PartTimeEmployee;
import com.jpahibernate.entity.Review;
import com.jpahibernate.entity.Student;

@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// studentRepository.saveStudentWithPassport();

		// repository.playWithEntityManager();
		// Course course = repository.findById(10001l);
		// logger.info("Course 10001 -> {}" + course);

		// repository.save(new Course ("microservices in 100 steps"));

		// repository.deleteById(10003l);
		// System.out.println("Course 10003 -> {}" + course);

		courseRepository.addHardCodedReviewsForCourse();
		/*
		 * List<Review> reviews = new ArrayList<>(); reviews.add(new Review("6",
		 * "Perfect Course")); reviews.add(new Review("2", "Hard Course"));
		 * 
		 * courseRepository.addReviewsForCourse(106l, reviews);
		 */

		// studentRepository.insertHardCodedStudentAndCourse();

		// studentRepository.insertStudentAndCourse(new Student("Mahesh"), new
		// Course("ReactJs"));

		//employeeRepository.insert(new PartTimeEmployee("Prashant", new BigDecimal("50")));
		//employeeRepository.insert(new FullTimeEmployee("vivek", new BigDecimal("10000")));
		//System.out.println("All Employees -> {}" + employeeRepository.retriveAllEmployee());

	}

}
