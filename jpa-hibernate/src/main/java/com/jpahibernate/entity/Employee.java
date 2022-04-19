package com.jpahibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="viraj_employee")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Employee {

	@Id
	@GeneratedValue
	private long id;

	@Column(nullable = false)
	private String name;

	protected Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}

	/*
	 * @Override public String toString() { return String.format("Course [%s]",
	 * name); }
	 */
}
