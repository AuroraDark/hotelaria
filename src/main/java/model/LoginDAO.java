package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	
	public boolean selecionarUsuario(Funcionario func) {
		String readUsuario = "SELECT * FROM funcionarios WHERE usuario = ?";
		try {
			boolean existe = false;
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(readUsuario);
			pst.setString(1, func.getUsuario());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				func.setCodFunc(rs.getString(1));
				func.setNome(rs.getString(2));
				func.setEmail(rs.getString(3));
				func.setUsuario(rs.getString(4));
				func.setSenha(rs.getString(5));
				func.setCpf(rs.getString(6));
				func.setDataNascimento(rs.getString(7));
				func.setCep(rs.getString(8));
				func.setNumEnd(rs.getString(9));
				func.setComplemento(rs.getString(10));
				existe = true;
			}
			con.close();
			return existe;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
