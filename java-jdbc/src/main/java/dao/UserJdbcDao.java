package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import conexaojdbc.SingleConnection;
import model.Telefone;
import model.UserJavaJdbc;

public class UserJdbcDao {// Dao -> Classe onde cria as operações de insert usando o objedo model

	private Connection connection;

	public UserJdbcDao() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(UserJavaJdbc user) {

		try {

			// SQL para inserir um novo usuário na tabela userjavajdbc
			String sql = "insert into userjavajdbc (nome, email) values (?,?)";

			// Prepara o comando SQL para execução
			PreparedStatement insert = connection.prepareStatement(sql);

			// Define os valores dos parâmetros na ordem (1 = id, 2 = nome, 3 = email)
			insert.setString(1, user.getNome());
			insert.setString(2, user.getEmail());

			// Executa o INSERT no banco de dados
			insert.execute();

			// Faz o commit (grava definitivamente no banco)
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void salvarTelefone(Telefone telefone) {
		
		try {
			
			String sql = "insert into telefoneuser(numero, tipo, usuariopessoa) values(?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, telefone.getNumero());
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getUsuario());
			
			
			statement.execute();
			connection.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public List<UserJavaJdbc> listar() {// Retorna a linsa de users

		List<UserJavaJdbc> list = new ArrayList();

		// SQL para buscar todos os registros da tabela userjavajdbc
		String sql = "select * from userjavajdbc";

		try {
			// Prepara a instrução SQL para execução
			PreparedStatement statement = connection.prepareStatement(sql);

			// Executa a consulta (SELECT) e armazena o resultado
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {// Enquanto houver próxima linha no resultado

				// Cria um novo objeto UserJavaJdbc
				UserJavaJdbc userJavaJdbc = new UserJavaJdbc();
				// Preenche os dados do objeto com os dados da linha atual
				userJavaJdbc.setId(resultado.getLong("id"));
				userJavaJdbc.setNome(resultado.getString("nome"));
				userJavaJdbc.setEmail(resultado.getString("email"));

				// Adiciona o objeto preenchido à lista
				list.add(userJavaJdbc);
			}

		} catch (Exception e) {
			// Em caso de erro, imprime a exceção
			e.printStackTrace();
		}

		// Retorna a lista com todos os usuários encontrados
		return list;
	}

	public UserJavaJdbc buscar(Long id) throws Exception {// Retorna apenas um ou nenhum

		UserJavaJdbc retorno = new UserJavaJdbc();

		String sql = "select * from userjavajdbc";

		PreparedStatement statement = connection.prepareStatement(sql);// Prepara a instrução SQL para execução
		ResultSet resultado = statement.executeQuery();// Executa a consulta (SELECT) e armazena o resultado

		while (resultado.next()) {// Enquanto houver próxima linha no resultado

			// Cria um novo objeto UserJavaJdbc
			UserJavaJdbc userJavaJdbc = new UserJavaJdbc();

			// Preenche os dados do objeto com os dados da linha atual
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));

		}
		return retorno;
	}

	public void atualizar(UserJavaJdbc user) {

		try {
			String sql = "update userjavajdbc set nome = ? where id = " + user.getId();

			PreparedStatement statmant = connection.prepareStatement(sql);

			statmant.setString(1, user.getNome());

			statmant.execute();
			connection.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void deletar(Long id) {
		try {
		UserJavaJdbc user = new UserJavaJdbc();
		
		String sql = "delete from userjavajdbc where id = " + id;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.execute();
		connection.commit();
		
		}catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void deletarFones(Long id){
		try {
			
			UserJavaJdbc user = new UserJavaJdbc();
			
			String sqlFone = "delete from telefoneuser where usuariopessoa = " + id;
			String sqlUser = "delete from userjavajdbc where id = " + id;
			PreparedStatement statement = connection.prepareStatement(sqlFone);
						
			statement.executeUpdate();
			connection.commit();
			
			PreparedStatement statement02 = connection.prepareStatement(sqlUser);
			statement02.executeUpdate();
			connection.commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
