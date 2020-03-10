package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

	private static final String URL = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
	private static final String USUARIO = "root";
	private static final String SENHA = "root";

	public static void main(String[] args) throws SQLException {

		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

		Statement stmt = conexao.createStatement();

		stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");

		System.out.println("Banco criado com sucesso");

		conexao.close();
	}

}
