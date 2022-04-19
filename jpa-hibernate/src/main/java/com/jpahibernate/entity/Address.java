package com.jpahibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	protected Address() {
	}
	
	private String line1;
	private String line2;
	private String city;
	
	public Address(String line1, String line2, String city) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
	}
	
	
}
