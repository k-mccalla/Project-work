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
		List<Item> item = null;
		return new Order(orderID, price, customerID, item);

	}


	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT c.order_id, c.item_id, o.fk_id, o.price FROM orders o inner join order_items c on o.order_id=c.item_id");) {
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
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(fk_id) VALUES (?)");) {
			//statement.setDouble(1, order.getPrice());
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
			statement.executeUpdate();
						
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return read(itemID);
	}
	
	public List<Order> readAllItems(Long itemID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * from order_items WHERE order_id = ?");) {
			statement.setLong(1, itemID);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return (List<Order>) modelFromResultSet1(resultSet);
			}
						
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return (List<Order>) read(itemID);
	}
	
	
	
	public Order calculateOrder(Long orderID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT sum(price) from orders where order_id = ?");) {
			statement.setLong(1, orderID);
			//statement.setLong(2, itemID);
			statement.executeUpdate();
						
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());

		}
		return read(orderID);
	}
	
	

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
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE orders SET item_id = ?  WHERE order_id = ?");) {
			statement.setLong(1, t.getOrderID());
			statement.setLong(2, t.getItem());
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
