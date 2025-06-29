package java_jdbc.java_jdbc;

import org.junit.jupiter.api.Test;

import conexaojdbc.SingleConnection;
import dao.UserJdbcDao;
import model.UserJavaJdbc;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		UserJdbcDao userJdbcDao = new UserJdbcDao();
		
		UserJavaJdbc userJavaJdbc = new UserJavaJdbc();
		
		userJavaJdbc.setId(5L);
		userJavaJdbc.setNome("Charles");
		userJavaJdbc.setEmail("charles@gmailcom");
		
		userJdbcDao.salvar(userJavaJdbc);
	}

}
