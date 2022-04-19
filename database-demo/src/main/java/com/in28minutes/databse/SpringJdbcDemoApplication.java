/*
 * package com.in28minutes.databse;
 * 
 * import java.util.Date;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.CommandLineRunner; import
 * org.springframework.boot.SpringApplication; import
 * org.springframework.boot.autoconfigure.SpringBootApplication;
 * 
 * import com.in28minutes.databse.entity.Person; import
 * com.in28minutes.databse.jdbc.PersonJdbcDao;
 * 
 * //@SpringBootApplication public class SpringJdbcDemoApplication implements
 * CommandLineRunner {
 * 
 * Logger logger = LoggerFactory.getLogger(this.getClass());
 * 
 * @Autowired PersonJdbcDao dao;
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(SpringJdbcDemoApplication.class, args); }
 * 
 * @Override public void run(String... args) throws Exception {
 * //System.out.printf("All users -> {}", dao.findAll());
 * 
 * logger.info("All users -> {}", dao.findAll());
 * 
 * logger.info("User id 10001 -> {}", dao.findById(10001));
 * 
 * logger.info("Deleting 10002 -> No of Rows Deleted - {}",
 * dao.deleteById(10002));
 * 
 * //logger.info("inserting 10004 -> {}", dao.insert(new Person (10005,
 * "vishakha", // /"Dubai", new Date())));
 * 
 * //logger.info("update 10004 -> {}", dao.update(new Person //(10004, "vivek",
 * "Pune", new Date())));
 * 
 * System.out.printf("Update 10004 - > {}"+ dao.update(new Person(10004,
 * "Vivek", "Pune", new Date())));
 * 
 * } }
 */