package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	private static final String URL = "jdbc:mysql://localhost:3306/curso_java?verifyServerCertificate=false&useSSL=true";
	private static final String USUARIO = "root";
	private static final String SENHA = "root";

	public static Connection getConexao() {
		try {
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
