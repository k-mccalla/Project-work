package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.qa.ims.controller.ItemController;

import com.qa.ims.persistence.dao.ItemDAO;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)

public class ItemControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;
	
	@Test
	public void testCreate() {
		final String ITEM_NAME = "W";
		final Double PRICE = 50.0;
		final Item created = new Item(PRICE, ITEM_NAME);

		Mockito.when(utils.getString()).thenReturn(ITEM_NAME);
		Mockito.when(utils.getDouble()).thenReturn(PRICE);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(utils, Mockito.times(2)).getDouble();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(50.0, "w"));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testUpdate() {
		Item updated = new Item(1L, 50D, "w");

		Mockito.when(this.utils.getLong()).thenReturn(updated.getItemID());
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getDouble()).thenReturn(updated.getPrice());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(2)).getString();
		Mockito.verify(this.utils, Mockito.times(2)).getDouble();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}
	@Test
	public void testDelete() {
		final long ItemID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ItemID);
		Mockito.when(dao.delete(ItemID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ItemID);
}
	@After
	public void finalise() {
		System.out.println("After test");
	}
}