package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {

	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Item created = new Item(5L, 50D, "Xbox");
		assertEquals(created, DAO.create(created));
		System.out.println("Test create");
	}
 
	@Test 
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(9L, 100D, "w"));
		assertEquals(expected, DAO.readAll());
		System.out.println("Test Read All");
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Item(3L, 50D, "Xbox"), DAO.readLatest());
		System.out.println("Test Read latest");
	}

	@Test
	public void testRead() { 
		final long item_id = 3L;
		final double price = 50D;
		assertEquals(new Item(item_id, price, "Xbox"), DAO.read(item_id));
		System.out.println("Test read");
	}  

	@Test
	public void testUpdate() {
		final Item updated = new Item(40D, "Mouse");
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