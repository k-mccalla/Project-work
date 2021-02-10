package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final long fk_id = 3L;
		final Order created = new Order(3L);
		assertEquals(created, DAO.create(created));
		System.out.println("Test create"); 
	}
 
	@Test 
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(2L, 200D, 7L, null));
		assertEquals(expected, DAO.readAll());
		System.out.println("Test Read All");
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(2L, 200D, 7L, null), DAO.readLatest());
		System.out.println("Test Read latest");
	}

	@Test
	public void testRead() { 
		final long order_id = 3L;
		assertEquals(new Order(order_id), DAO.read(order_id));
		System.out.println("Test read");
	}  

	@Test
	public void testUpdate() {
		final long item_id = 3L;
		final Order updated = new Order(null);
		assertEquals(new Order(item_id), DAO.update(updated)); 
		System.out.println("Test update");

	} 
	@Test
	public void addItem() {
		final Order updated = new Order(1D, 1L);
		assertEquals(updated, DAO.update(updated)); 
		System.out.println("Test update");

	}
	@Test
	public void removeItem() {
		final Order updated = new Order(1L, null);
		assertEquals(updated, DAO.update(updated)); 
		System.out.println("Test update");

	}
	@Test 
	public void calculateItem() {
		final Order updated = new Order(null);
		assertEquals(updated, DAO.update(updated)); 
		System.out.println("Test update");

	}
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
		System.out.println("Test delete");
	}
	@After
	public void finalise() {
		System.out.println("After test");
	} 

}
