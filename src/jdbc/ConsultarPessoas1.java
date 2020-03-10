package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas1 {

	public static void main(String[] args) throws SQLException {

		Connection conexao = FabricaConexao.getConexao();

		String sql = "SELECT * FROM pessoas";

		Statement stmt = conexao.createStatement();
		ResultSet resultado = stmt.executeQuery(sql);

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		while (resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));
		}

		pessoas.forEach(System.out::println);

		conexao.close();

	}

}
