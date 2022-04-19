package com.in28minutes.databse;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.databse.entity.Person;
import com.in28minutes.databse.jdbc.PersonJdbcDao;
import com.in28minutes.databse.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	//	System.out.printf("All users -> {}" + repository.findById(10003));

		/*
		 * System.out.printf("Inserting 10006 - > {}"+ repository.insert(new
		 * Person(10006, "Pankaj", "hadgaon", new Date())));
		 */
		//System.out.printf("Update 10003 - > {}" + repository.update(new Person(10003, "Vishakha", "Dubai", new Date())));

		//repository.deleteById(66);
		
		System.out.printf("All users -> {}" + repository.findAll());

		// logger.info("User id 10001 -> {}", repository.findById(10001));

		/*
		 * System.out.printf("All users -> {}", dao.findAll());
		 * 
		 * logger.info("All users -> {}", dao.findAll());
		 * 
		 * logger.info("Deleting 10002 -> No of Rows Deleted - {}",
		 * dao.deleteById(10002));
		 * 
		 * logger.info("inserting 10004 -> {}", dao.insert(new Person (10005,
		 * "vishakha", "Dubai", new Date())));
		 * 
		 * logger.info("update 10004 -> {}", dao.update(new Person (10004, "vivek",
		 * "Pune", new Date())));
		 * 
		 * System.out.printf("Update 10004 - > {}"+ dao.update(new Person(10004,
		 * "Vivek", "Pune", new Date())));
		 */
	}
}