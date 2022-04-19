package com.jpahibernate.courseRepository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.jpahibernate.JpaHibernateApplication;
import com.jpahibernate.entity.Course;

@SpringBootTest(classes = JpaHibernateApplication.class)
class CourseSpringDataRepositoryTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository repository;

	@Test
	public void findById_CoursePresent() {
		Optional<Course> courseOptional = repository.findById(101l);
		// System.out.println("Course isPresent {}" + courseOptional.isPresent());
		assertTrue(courseOptional.isPresent());
	}

	@Test
	public void findById_CourseNotPresent() {
		Optional<Course> courseOptional = repository.findById(201l);
		// System.out.println("Course isPresent {}" + courseOptional.isPresent());
		assertFalse(courseOptional.isPresent());
	}

	@Test
	public void playingAroundWithSpringDataRepository() {
		// Course course = new Course ("DBMS");
		// repository.save(course);

		// course.setName("Networking - updated");
		// repository.save(course);

		System.out.println("Course -> {}" + repository.findAll());
		System.out.println("Count - > {}" + repository.count());
	}

	/*
	 * @Test public void sort() { Sort sort = new Sort(Sort.Direction.DESC, "name");
	 * 
	 * }
	 */

	@Test
	public void pagination() {
		PageRequest pageRequest = PageRequest.of(0, 3);
		Page<Course> firstPage = repository.findAll(pageRequest);
		System.out.println("First Page -> {}" + firstPage.getContent());

		Pageable secondPageable = firstPage.nextPageable();
		Page<Course> secondPage = repository.findAll(secondPageable);
		System.out.println("Second Page - > {}" + secondPage.getContent());
	}

}
