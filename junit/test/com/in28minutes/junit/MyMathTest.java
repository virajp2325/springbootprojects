package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMathTest {
	
	MyMath myMath = new MyMath ();

	@BeforeEach
	public void before() {
		System.out.println("Before");
	} 
	@BeforeEach
	public void after() {
		System.out.println("After");
	}
	@BeforeAll
	public static void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterAll
	public static void afterClass() {
		System.out.println("After Class");
	}
	
	@Test
	public void sum_with3numberst() {
		System.out.println("Test1");
		assertEquals(6, myMath.sum(new int [] {1,2,3}));
	}
	
	@Test
	public void sum_with1numberst() {
		System.out.println("Test2");
		assertEquals(3, myMath.sum(new int [] {3}));
	}
	
}
