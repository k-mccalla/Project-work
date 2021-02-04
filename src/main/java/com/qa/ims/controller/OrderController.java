package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
	

//	@Override
//	public List<Order> read() {
//		LOGGER.info("Select order in database:");
//		List<Order> orders = (List<Order>) orderDAO.read;
//		for (Order order : orders) {
//			LOGGER.info(order);
//
//		}
//
//		return orders;
	

	@Override
	public Order create() {
		LOGGER.info("Please enter order price"); // unsure if should include price
		Long price = utils.getLong();
		LOGGER.info("Please enter order quantity");
		Long quantity = utils.getLong();
		LOGGER.info("Please enter the Customer ID for this order");
		Long fkID = utils.getLong();
		LOGGER.info("Please enter the Item ID for this order");
		Long fkItemID = utils.getLong();
		LOGGER.info("Please enter the order date (in YYYY-MM-DD format)");
		String date = utils.getString();
		// String updatedDate;
		// try {
		// updatedDate = (Date) new SimpleDateFormat("YYYY-MM-DD").parse(date);

		Order order = orderDAO.create(new Order(price, quantity, fkID, date, fkItemID));
		LOGGER.info("Order successfully added");
		return order;
	}

	@Override
	public Order update() {
		LOGGER.info("Please enter the order id you wish to update");
		long orderID = utils.getLong();
		LOGGER.info("Please enter the updated order price");
		long price = utils.getLong();
		LOGGER.info("Please enter the updated order quantity");
		long quantity = utils.getLong();
		LOGGER.info("Please enter the Customer ID for this order");
		Long fkID = utils.getLong();
		LOGGER.info("Please enter the Item ID for this order");
		Long fkItemID = utils.getLong();
		LOGGER.info("Please enter the updated order date (in YYYY-MM-DD format)");
		String date = utils.getString();
		// Date updatedDate;
		// try {
		// updatedDate = (Date) new SimpleDateFormat("YYYY-MM-DD").parse(date);
		// java.sql.Date dateF = new java.sql.Date(updatedDate.toString());
		// Date date1 = new Date();
		// Date date1 =new Date(updatedDate.getTime());

		Order order = orderDAO.create(new Order(orderID, price, fkID, date, quantity, fkItemID));

		LOGGER.info("Order successfully updated");
		return order;
	}

	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you wish to delete");
		long orderID = utils.getLong();
		LOGGER.info("Order successfully deleted");
		return orderDAO.delete(orderID);

	}

}
