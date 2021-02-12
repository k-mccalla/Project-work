package com.qa.ims.persistence.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

	Customer customer = new Customer(null, null, null);	
	@BeforeClass
	public static void setup() {
  
	}  
  
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}

	 
	@Test
	public void test2() {
		 
		
	}
	
	

	@After
	public void finalise() {
		System.out.println("After test");
	}
}
