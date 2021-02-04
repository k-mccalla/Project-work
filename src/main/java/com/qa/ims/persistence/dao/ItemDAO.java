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
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item> {

	public static final Logger LOGGER = LogManager.getLogger();

	public Item modelFromResultSet1(ResultSet resultSet) throws SQLException {
		String itemName = resultSet.getString("item_name"); //
		Long itemID = resultSet.getLong("item_id");
		Long price = resultSet.getLong("price");
		Long quantity = resultSet.getLong("quantity");
		return new Item(itemID, price, itemName, quantity);
	}

	@Override
	public List<Item> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items");) {
			List<Item> items = new ArrayList<>();
			while (resultSet.next()) {
				items.add(modelFromResultSet1(resultSet));
			}
			return items;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}


	public Item readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY item_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet1(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	

	@Override
	public Item create(Item item) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO items(item_name, price, quantity) VALUES (?, ?, ?)");) {
			statement.setString(1, item.getItemName());
			
			statement.setLong(2, item.getPrice());
			statement.setLong(3, item.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public int delete(long itemID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE item_id = ?");) {
			statement.setLong(1, itemID);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return 0;
	}

	public Item read(Double itemID) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE item_id = ?");) {
			statement.setDouble(1, itemID);
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
	public Item update(Item t) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE items SET item_name = ?, price = ?, quantity = ? WHERE id = ?");) {
			statement.setString(1, t.getItemName());
			statement.setLong(2, t.getPrice());
			statement.setLong(3, t.getQuantity());
			statement.setLong(4, t.getItemID());
			statement.executeUpdate();
			return read(t.getItemID());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}

		return null;
	}

	@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	}


