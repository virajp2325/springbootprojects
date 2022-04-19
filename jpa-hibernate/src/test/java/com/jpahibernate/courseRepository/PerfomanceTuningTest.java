package com.jpahibernate.courseRepository;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jpahibernate.JpaHibernateApplication;
import com.jpahibernate.entity.Course;

@SpringBootTest(classes = JpaHibernateApplication.class)
class PerfomanceTuningTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void creatingNPlusOneProblem() {
		List<Course> courses = em.createNamedQuery("Query_get", Course.class).getResultList();

		for (Course course : courses) {
			System.out.printf("Course ->{} Students ->" + course, course.getStudents());
		}
	}

	@Test
	@Transactional
	public void solvingNPlusOneProblem_EntityGraph() {
		EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
		Subgraph<Object> subGraph = entityGraph.addSubgraph("students");
		List<Course> courses = em.createNamedQuery("Query_get", Course.class)
				.setHint("javax.persistence.loadgraph", entityGraph).getResultList();

		for (Course course : courses) {
			System.out.printf("Course ->{} Students ->" + course, course.getStudents());
		}
	}

}
