package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

	public static void main(String[] args) throws SQLException {

		Scanner entrada = new Scanner(System.in);

		System.out.print("Informe o codigo da pessoa que sera excluida: ");
		int codigo = entrada.nextInt();

		String sql = "DELETE FROM pessoas WHERE codigo = ?";
		Connection conexao = FabricaConexao.getConexao();

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, codigo);
		stmt.execute();

		System.out.println("Pessoa removida com sucesso!!!");

		stmt.close();
		conexao.close();
		entrada.close();

	}

}
