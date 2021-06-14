package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class QuartoDAO {
	//Parâmetros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbhotelaria?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "Dba@123";
	
	//Conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/**CRUD READ**/
	public ArrayList<Quarto> listarQuartos() {
		ArrayList<Quarto> listaquartos = new ArrayList<>();
		String readquarto = "select * from quartos order by numQuarto";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(readquarto);
			ResultSet rs = pst.executeQuery();
			//Enquanto houver quartos
			while(rs.next()) {
				// Variáveis temporárias pra receber os dados
				int numQuarto = rs.getInt(1);
				String descricao = rs.getString(2);
				double valorDiaria = rs.getDouble(3);
				boolean statusDisp = rs.getBoolean(4);
				// Colocar tudo no Array
				listaquartos.add(new Quarto(numQuarto,descricao,valorDiaria,statusDisp));
			}
			con.close();
			return listaquartos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}