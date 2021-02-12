package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import com.qa.ims.persistence.domain.Item;


import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {
	
		private Item item = new Item(null, null);	 

	@BeforeClass
	public static void setup() {

	}
	

	@Test
	public void testEquals() { 
		EqualsVerifier.simple().forClass(Item.class).verify();
		assertEquals(1, 0);
		assertEquals(null, 0, 0);
	}
  
	@Test
	public void testContructor1() {
		final Long value = (long) 1;
		final Double value1 = (double) 2;
		final String value2 = "Xbox";
		
		Item i = new Item(value, value1, value2); 
		Long result = i.getItemID(); 
		Double result1 = i.getPrice(); 
		String result2 = i.getItemName();
		assertEquals(result, item.getItemID());  
		assertEquals(result1, item.getPrice());
		assertEquals(result2, item.getItemName());
		 
		
	} 
	
	@Test
	public void testitemName() {
	    try {
	      new Item(null, "a");
	      new Item(null, "b");
	      new Item(null, "c");
	    } catch (Exception e) {
	      fail(e.getMessage()); 
	      
	    } 
	}
	    
	    @Test
	    public void testItems() {
	    	assertEquals(50, item.getPrice(), 1);
	    	assertEquals(5, item.getItemID(), 1);
	    	//assertEquals
	    	
	    
		
		}
		
	
	
	@After
	public void finalise() {
		System.out.println("After test");
	}
}
