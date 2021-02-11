package com.qa.ims.persistence.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;

import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	public Order modelFromResultSet1(ResultSet resultSet) throws SQLException {
		Long orderID = resultSet.getLong("order_id");
		Double price = resultSet.getDouble("price");
		Long customerID = resultSet.getLong("fk_id");
		//Long itemID = resultSet.getLong("item_id");
		List<Item> items = readItems(orderID);
		return new Order(orderID, price, customerID, items);

	}

	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");){
			List<Order> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet1(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Order read(Long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
			statement.setLong(1, orderID);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet1(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return null;
	}

	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("INSERT INTO orders(fk_id) VALUES (?)");) {

			statement.setLong(1, order.getCustomerID());

			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return null;

	}

	public Order addItem(Long orderID, Long itemID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items(order_id, item_id) VALUES (?, ?)");) {
			statement.setLong(1, orderID);
			statement.setLong(2, itemID);
			statement.executeUpdate();

		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return read(orderID);
	}

	public Order removeItem(Long itemID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE item_id FROM order_items WHERE order_id = ?");) {
			statement.setLong(1, itemID);
			//statement.setLong(2, orderID);
			statement.executeUpdate();

		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return read(itemID);
	}

	public List<Item> readItems(Long orderID) {
		List<Long> itemID = new ArrayList<>();
		List<Item> items = new ArrayList<>();
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_items where order_id = " + orderID);){

			while (resultSet.next()) {
				itemID.add(resultSet.getLong("item_id"));
			}
			
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		
			//long [] itemID = {};
			for(Item item : items) {
				if (item instanceof Item) {
					item.getItemID();
					item.getPrice();
				}
					
				// List<Item> items = ItemDAO.readAll();
				 
			}
		}
		return new ArrayList<Item>();
	}
		
		

//	public Order calculateOrder(Long orderID) {
//		try (Connection connection = DBUtils.getInstance().getConnection();
//				PreparedStatement statement = connection
//						.prepareStatement("SELECT sum(price) from orders where order_id = ?");) {
//			statement.setLong(1, orderID);
//			// statement.setLong(2, itemID);
//			statement.executeUpdate();
//
//		} catch (Exception e) {
//			LOGGER.debug(e);
//			LOGGER.error(e.getMessage());
//
//		}
//		return read(orderID);
	

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet1(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
 
	@Override
	public Order update(Order t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET item_id = ?  WHERE order_id = ?");) {
			statement.setLong(1, t.getOrderID());
			statement.setObject(2, t.getItem());
			statement.executeUpdate();
			return read(t.getOrderID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return null;
	}

	@Override
	public int delete(long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1, orderID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return 0;
	}

	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
