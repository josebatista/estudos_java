package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

	public static void main(String[] args) throws SQLException {

		System.out.print("Informe o nome que deseja buscar: ");
		Scanner entrada = new Scanner(System.in);
		String valorEntrada = entrada.nextLine();

		String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";

		Connection conexao = FabricaConexao.getConexao();

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, '%' + valorEntrada + '%');

		ResultSet resultado = stmt.executeQuery();

		List<Pessoa> lista = new ArrayList<>();

		while (resultado.next()) {
			int codigo = resultado.getInt("codigo");
			String nome = resultado.getString("nome");
			lista.add(new Pessoa(codigo, nome));
		}

		lista.forEach(System.out::println);

		stmt.close();
		conexao.close();
		entrada.close();
	}

}
