package com.qa.ims.controller;

import java.util.List;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.ItemDAO;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

//Item details for CRUD

public class ItemController implements CrudController<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO; // using these classes
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) { 
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
//Items to logger
	
	@Override
	public List<Item> readAll() {
		LOGGER.info("All current items in inventory:");
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item); 
			
		}		
		return items;
	}

	@Override
	public Item create() {
		LOGGER.info("Please enter item name");
		String itemName = utils.getString();	
		LOGGER.info("Please enter item price");
		Double price = utils.getDouble();
		Item item = itemDAO.create(new Item(price, itemName)); 
		LOGGER.info("Item listing created");
		return item;
		
	}

	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you wish to update");
		long itemID = utils.getLong();
		LOGGER.info("Please enter the name of the item you wish to update");
		String itemName = utils.getString();
		LOGGER.info("Please enter the price of the item you wish to update");
		Double price = utils.getDouble();
		Item item = itemDAO.create(new Item(itemID, price , itemName));
	    LOGGER.info("Item successfully updated");
		return item;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you wish to delete");
		long itemID = utils.getLong();
		LOGGER.info("Item successfully deleted");
		return itemDAO.delete(itemID);
	}

	

}
