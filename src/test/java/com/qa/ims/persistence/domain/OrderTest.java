package com.qa.ims.persistence.domain;

import org.junit.BeforeClass;
import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {

	Order order = new Order(null);	
	@BeforeClass
	public static void setup() {
  
	}  
  
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}
 
	 
	@Test
	public void test2() {
		
	}
	
	
}
