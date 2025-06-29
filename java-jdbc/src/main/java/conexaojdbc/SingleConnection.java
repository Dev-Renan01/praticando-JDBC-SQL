package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
     private static String url = "jdbc:postgresql://localhost:5432/javajdbcx";// String de conexão com o banco de dados PostgreSQL
     private static String user = "postgres";// Usuário
     private static String password = "220822xxx";// Senha
    private static Connection connection = null;// Objeto de conexão


    // Bloco estático: executado automaticamente quando a classe é carregada
    static {
        conectar(); // Tenta estabelecer conexão ao carregar a classe
    }

    
    public SingleConnection() {
        conectar();
    }

    private static void conectar() {// Método que realiza a conexão com o banco de dados
    	
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver"); // Carrega o driver JDBC do PostgreSQL
                connection = DriverManager.getConnection(url, user, password); // Cria a conexão
                connection.setAutoCommit(false); // Desativa o auto-commit (transações manuais)
                System.out.println("Banco conectado com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Mostra qualquer erro ocorrido na tentativa de conexão
        }
    }

    // Método que retorna a conexão ativa para outras classes usarem
    public static Connection getConnection() {
        return connection;
    }
}

