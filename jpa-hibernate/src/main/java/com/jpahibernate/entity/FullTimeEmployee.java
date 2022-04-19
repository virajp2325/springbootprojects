package com.jpahibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="viraj_full_time_employee")
public class FullTimeEmployee extends Employee {

	protected FullTimeEmployee() {
	}

	public FullTimeEmployee(String name, BigDecimal salary) {
		super(name);
		this.salary = salary;
	}

	private BigDecimal salary;

}
