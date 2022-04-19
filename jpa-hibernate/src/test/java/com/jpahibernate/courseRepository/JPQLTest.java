package com.jpahibernate.courseRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.jpahibernate.JpaHibernateApplication;
import com.jpahibernate.entity.Course;

@SpringBootTest(classes = JpaHibernateApplication.class)
public class JPQLTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	@DirtiesContext
	public void jpql_Basic() {
		List resultList = em.createQuery("select c from Course c").getResultList();
		logger.info("Select c from Course c -> {}", resultList);
	}

	/*
	 * @Test public void jpql_courses_without_students() { TypedQuery<Course> query
	 * =
	 * em.createQuery("select c from viraj_course c where c.viraj_student is empty",
	 * Course.class); List<Course> resultList = query.getResultList();
	 * System.out.println("Result - > {}" + resultList); }
	 */

}
