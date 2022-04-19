package com.jpahibernate.courseRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jpahibernate.entity.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void insert(Employee employee) {
		em.persist(employee);
	}

	public List<Employee> retriveAllEmployee() {
		return em.createQuery("select v from Employee v ", Employee.class).getResultList();
	}	
}
