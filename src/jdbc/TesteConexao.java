package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

	private static final String url = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
	private static final String usuario = "root";
	private static final String senha = "root";

	public static void main(String[] args) throws SQLException {

		Connection conexao = DriverManager.getConnection(url, usuario, senha);

		System.out.println("Conectado com sucesso!");

		conexao.close();

	}

}
