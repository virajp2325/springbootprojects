package com.in28minutes.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class AssertTest {

	@Test
	public void test() {
		boolean condn = true;
		assertEquals(true, condn);
		assertTrue(condn);
		assertFalse(condn);
	}

}
