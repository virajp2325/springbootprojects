package com.jpahibernate.courseRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.jpahibernate.JpaHibernateApplication;
import com.jpahibernate.entity.Course;

@SpringBootTest(classes = JpaHibernateApplication.class)
public class CriteriaTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void all_courses() {

		// Select c from course c
		// 1 Use Criteria buider to create a Creiteria Query returning the
		// expected result
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2 Define roots for the tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3 Define predicates etc using criteria builder
		// 4 Add predicates etc to the criteria Query

		// 5 Build the TypedQuery using the entity Manager and Criteria Query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultlist = query.getResultList();
		System.out.println("Typed Query -> {}" + resultlist);
	}

	@Test
	public void all_courses_having_100Steps() {

		// "Select c from course c where name like '%100%' "

		// 1 Use Criteria buider to create a Creiteria Query returning the
		// expected result
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2 Define roots for the tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3 Define predicates etc using criteria builder
		Predicate like100Steps = cb.like(courseRoot.get("name"), "%100 Steps");

		// 4 Add predicates etc to the criteria Query
		cq.where(like100Steps);

		// 5 Build the TypedQuery using the entity Manager and Criteria Query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultlist = query.getResultList();
		System.out.println("Typed Query -> {}" + resultlist);
	}

	@Test
	public void all_courses_without_student() {

		// "Select c from course c where student is empty "

		// 1 Use Criteria buider to create a Creiteria Query returning the
		// expected result
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2 Define roots for the tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3 Define predicates etc using criteria builder
		Predicate studentIsEmpty = cb.isEmpty(courseRoot.get("students"));

		// 4 Add predicates etc to the criteria Query
		cq.where(studentIsEmpty);

		// 5 Build the TypedQuery using the entity Manager and Criteria Query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultlist = query.getResultList();
		System.out.println("Typed Query -> {}" + resultlist);
	}
	
	@Test
	public void join() {

		// "Select c from course c join c.student s "

		// 1 Use Criteria buider to create a Creiteria Query returning the
		// expected result
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2 Define roots for the tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3 Define predicates etc using criteria builder
		Join<Object, Object> join = courseRoot.join("students");

		// 4 Add predicates etc to the criteria Query

		// 5 Build the TypedQuery using the entity Manager and Criteria Query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultlist = query.getResultList();
		System.out.println("Typed Query -> {}" + resultlist);
	}
	
	@Test
	public void left_join() {

		// "Select c from course c left join c.student s "

		// 1 Use Criteria buider to create a Creiteria Query returning the
		// expected result
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);

		// 2 Define roots for the tables which are involved in the query
		Root<Course> courseRoot = cq.from(Course.class);

		// 3 Define predicates etc using criteria builder
		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);

		// 4 Add predicates etc to the criteria Query

		// 5 Build the TypedQuery using the entity Manager and Criteria Query
		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
		List<Course> resultlist = query.getResultList();
		System.out.println("Typed Query -> {}" + resultlist);
	}
	
}
