package java_jdbc.java_jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;

import conexaojdbc.SingleConnection;
import dao.UserJdbcDao;
import model.UserJavaJdbc;

public class TesteBancoJdbc {

	//@Test
	public void initBanco() {
		UserJdbcDao userJdbcDao = new UserJdbcDao();
		UserJavaJdbc userJavaJdbc = new UserJavaJdbc();

		userJavaJdbc.setId(5L);
		userJavaJdbc.setNome("Charles");
		userJavaJdbc.setEmail("charles@gmailcom");

		userJdbcDao.salvar(userJavaJdbc);
	}
	
	//@Test
	public void initListar() {
		UserJdbcDao dao = new UserJdbcDao();

		try {
			List<UserJavaJdbc> list = dao.listar();

			for (UserJavaJdbc u : list) {
				System.out.println(u);
				System.out.println("___________________________________________");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	//@Test
	public void initBuscar() {
		UserJdbcDao dao = new UserJdbcDao();
		
		try {
			UserJavaJdbc userJavaJdbc = dao.buscar(2L);
			
			System.out.println(userJavaJdbc);
						
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Test
	public void initAtualizar() {
		try {
			UserJdbcDao dao = new UserJdbcDao();

			UserJavaJdbc objetoBanco = dao.buscar(5L);
			
			dao.atualizar(objetoBanco);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
