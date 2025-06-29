package dao;

import java.sql.Connection;

import conexaojdbc.SingleConnection;

public class UserJdbcDao {

	private Connection connection;
	
	public UserJdbcDao(Connection connection) {
		connection = SingleConnection.getConnection();
	}
}
