package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexaojdbc.SingleConnection;
import model.UserJavaJdbc;

public class UserJdbcDao {// Dao -> Classe onde cria as operações de insert usando o objedo model

	private Connection connection;

	
	public UserJdbcDao() {
		connection = SingleConnection.getConnection();
	}
	
	
	public void salvar(UserJavaJdbc user) {
		try {
		String sql = "insert into userjavajdbc (id, nome, email) values (?,?,?)";
		PreparedStatement insert = connection.prepareStatement(sql); //Realiza o insert
		insert.setLong(1, user.getId());
		insert.setString(2, user.getNome());
		insert.setString(3, user.getEmail());
		insert.execute();
		connection.commit();// Salvar no banco de dados
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
