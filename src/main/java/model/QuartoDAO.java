package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class QuartoDAO {
	
	/**CRUD READ**/
	public ArrayList<Quarto> listarQuartos() {
		ArrayList<Quarto> listaquartos = new ArrayList<>();
		String readquarto = "select * from quartos order by numQuarto";
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(readquarto);
			ResultSet rs = pst.executeQuery();
			//Enquanto houver quartos
			while(rs.next()) {
				// Vari�veis tempor�rias pra receber os dados
				int numQuarto = rs.getInt(1);
				String descricao = rs.getString(2);
				double valorDiaria = rs.getDouble(3);
				boolean statusDisp = rs.getBoolean(4);
				String urlImage = rs.getString(5);
				// Colocar tudo no Array
				listaquartos.add(new Quarto(numQuarto,descricao,valorDiaria,statusDisp,urlImage));
			}
			con.close();
			return listaquartos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	public void selecionarQuarto(Quarto quarto) {
		String readquarto = "select * from quartos where numQuarto = ?";
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pstc = con.prepareStatement(readquarto);
			pstc.setInt(1, quarto.getNumQuarto());
			ResultSet rsc = pstc.executeQuery();
			while(rsc.next()) {
				//Setar a vari�vel Cart�o
				 quarto.setNumQuarto(rsc.getInt(1));
				 quarto.setDescricao(rsc.getString(2));
				 quarto.setValorDiaria(rsc.getDouble(3));
				 quarto.setStatusDisp(rsc.getBoolean(4));
				 quarto.setUrlImage(rsc.getString(5));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}