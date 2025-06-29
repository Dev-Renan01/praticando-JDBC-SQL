package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.UserJavaJdbc;

public class UserJdbcDao {// Dao -> Classe onde cria as operações de insert usando o objedo model

	private Connection connection;

	
	public UserJdbcDao() {
		connection = SingleConnection.getConnection();
	}
	
	
	public void salvar(UserJavaJdbc user) {
		
	    try {
	    	
	        // SQL para inserir um novo usuário na tabela userjavajdbc
	        String sql = "insert into userjavajdbc (id, nome, email) values (?,?,?)";

	        // Prepara o comando SQL para execução
	        PreparedStatement insert = connection.prepareStatement(sql);

	        // Define os valores dos parâmetros na ordem (1 = id, 2 = nome, 3 = email)
	        insert.setLong(1, user.getId());
	        insert.setString(2, user.getNome());
	        insert.setString(3, user.getEmail());

	        // Executa o INSERT no banco de dados
	        insert.execute();

	        // Faz o commit (grava definitivamente no banco)
	        connection.commit();
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}

	
	public List<UserJavaJdbc> listar() {
		
	    List<UserJavaJdbc> list = new ArrayList();

	    // SQL para buscar todos os registros da tabela userjavajdbc
	    String sql = "select * from userjavajdbc";

	    try {
	    	
	        // Prepara a instrução SQL para execução
	        PreparedStatement statement = connection.prepareStatement(sql);

	        // Executa a consulta (SELECT) e armazena o resultado
	        ResultSet resultado = statement.executeQuery();
	     
	        while(resultado.next()) {// Enquanto houver próxima linha no resultado
	        	
	            // Cria um novo objeto UserJavaJdbc
	            UserJavaJdbc userJavaJdbc = new UserJavaJdbc();
	            // Preenche os dados do objeto com os dados da linha atual
	            userJavaJdbc.setId(resultado.getLong("id"));
	            userJavaJdbc.setNome(resultado.getString("nome"));
	            userJavaJdbc.setEmail(resultado.getString("email"));

	            // Adiciona o objeto preenchido à lista
	            list.add(userJavaJdbc);
	        }

	    } catch(Exception e) {
	        // Em caso de erro, imprime a exceção
	        e.printStackTrace();
	    }
	    
	    // Retorna a lista com todos os usuários encontrados
	    return list;
	}
}
