package com.jpahibernate.courseRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.jpahibernate.JpaHibernateApplication;
import com.jpahibernate.entity.Course;

@SpringBootTest(classes = JpaHibernateApplication.class)
public class NativeQueryTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	@DirtiesContext
	public void native_query_Basic() {
		Query query = em.createNativeQuery("select * from viraj_course");
		List resultList = query.getResultList();
		logger.info("select * from viraj_course -> {}", resultList);
	}
	
	@Test
	@DirtiesContext
	public void native_query_with_parameter() {
		Query query = em.createNativeQuery("select * from viraj_course where id = ?", Course.class);
		query.setParameter(1, 100l);
		List resultList = query.getResultList();
		logger.info("select * from viraj_course where id = 100", resultList);
		
	}
	
	@Test
	@DirtiesContext
	public void native_query_with_named_parameter() {
		Query query = em.createNativeQuery("select * from viraj_course where id = :id", Course.class);
		query.setParameter("id", 100l);
		List resultList = query.getResultList();
		logger.info("select * from viraj_course where id = 100", resultList);
		
	}
	
	@Test
	@Transactional
	public void native_queries_to_update() {
		Query query = em.createNativeQuery("Update viraj_course set last_updated_date=sysdate()", Course.class);
		int noOfRowsUpdated = query.executeUpdate();
		logger.info("noOfRowsUpdated -> {}", noOfRowsUpdated);
		
	}
	

}
