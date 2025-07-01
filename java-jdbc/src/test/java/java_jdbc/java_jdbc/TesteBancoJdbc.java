package java_jdbc.java_jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;

import conexaojdbc.SingleConnection;
import dao.UserJdbcDao;
import model.Telefone;
import model.UserJavaJdbc;

public class TesteBancoJdbc {

	//@Test
	public void initBanco() {
		UserJdbcDao userJdbcDao = new UserJdbcDao();
		UserJavaJdbc userJavaJdbc = new UserJavaJdbc();

		userJavaJdbc.setNome("Paulo");
		userJavaJdbc.setEmail("paulo@gmailcom");

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

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//@Test
	public void initAtualizar() {
		try {
			UserJdbcDao dao = new UserJdbcDao();

			UserJavaJdbc objetoBanco = dao.buscar(5L);

			dao.atualizar(objetoBanco);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	//@Test
	public void initDeletar() {
		try {
			UserJdbcDao dao = new UserJdbcDao();
			 dao.deletar(3L);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testeInsertTelefone() {
		Telefone telefone = new Telefone();
		
		telefone.setNumero("(81) 98977-3212");
		telefone.setTipo("Casa");
		telefone.setUsuario(7L);
		
		UserJdbcDao dao = new UserJdbcDao();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void deleteFonesPorUser() {
		
		try {
			
		UserJdbcDao dao = new UserJdbcDao();
		dao.deletarFones(8L);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
