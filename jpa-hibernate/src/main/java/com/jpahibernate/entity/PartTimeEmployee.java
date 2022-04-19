package com.jpahibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="viraj_part_time_employee")
public class PartTimeEmployee extends Employee {

	protected PartTimeEmployee() {
	}

	public PartTimeEmployee(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	private BigDecimal hourlyWage;

}
