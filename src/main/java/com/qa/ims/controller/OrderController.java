package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;



public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	@Override
	public List<Order> readAll() {
		
		
		
		
		LOGGER.info("All current orders in database:");
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order);
			
		}

		return orders;
	}
	
	

	@Override
	public Order create() {
	
		LOGGER.info("Please enter the Customer ID for this order");
		Long fkID = utils.getLong();
		Order order = orderDAO.create(new Order(fkID));
		LOGGER.info("Order successfully created");
		return order;
	}


	@Override
	public Order update() {
		Order orderUpdate = null;
		LOGGER.info("Please enter the order id you wish to update");
		long orderID = utils.getLong();
		LOGGER.info("Do you want to add or remove an item?");
		String input = utils.getString();	
        if (input.equals("Add")) {
        	LOGGER.info("Please enter the item id you wish to add");
        	long itemID = utils.getLong();
        	
        	return orderDAO.addItem(orderID, itemID);
        	
        }else if (input.equals("Remove")) {
        	LOGGER.info("Please enter the item id you wish to remove");
        	long itemID = utils.getLong();
        	
        	return orderDAO.removeItem(itemID);
        	
        }else { (catch (Exception e) 
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
        	
        }
        	Order order = orderDAO.update(new Order(orderID)); 

		LOGGER.info("Order successfully updated");
		return orderUpdate;
        } 
		


	@Override
	public int delete() {
		LOGGER.info("Please enter the order id of the order you wish to delete");
		long orderID = utils.getLong();
		LOGGER.info("Order successfully deleted");
		return orderDAO.delete(orderID);

	}

}
