package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdatePessoa {

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe o codigo da pessoa para a pesquisa: ");
		int valor = entrada.nextInt();

		String selectSQL = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
		String updateSQL = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement stmt = conexao.prepareStatement(selectSQL);
		stmt.setInt(1, valor);

		ResultSet resultado = stmt.executeQuery();

		if (resultado.next()) {
			Pessoa p = new Pessoa(resultado.getInt(1), resultado.getString(2));
			System.out.println(p);
			entrada.nextLine();

			System.out.print("Informe o novo nome: ");
			String novoNome = entrada.nextLine();

			stmt.close();
			stmt = conexao.prepareStatement(updateSQL);
			stmt.setString(1, novoNome);
			stmt.setInt(2, valor);
			stmt.execute();

			System.out.println("Nome alterado com sucesso!");

		} else {
			System.out.println("Pessoa nao encontrada!");
		}

		stmt.close();
		conexao.close();
		entrada.close();
	}

}
