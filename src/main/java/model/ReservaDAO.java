package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ReservaDAO {
	
	/** CRUD CREATE **/
	/**
	 * @param reserva
	 */
	public void inserirReserva(Reserva reserva) {
		String createreserva = "insert into reservas(codCli, dataInicio, dataFim) values (?,str_to_date(?,'%Y-%m-%d'),str_to_date(?,'%Y-%m-%d'))";
		
		try {
			// Abrir a conexão com o BD
			Connection con = new ConexaoBD().conectar();
			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(createreserva);
			// Substituir os '?' pelo conteúdo da variável Reserva
			pst.setString(1, reserva.getCodCli());
			pst.setString(2, reserva.getDataInicio());
			pst.setString(3, reserva.getDataFim());
			
			// Executar a query (enviar para o BD)
			pst.executeUpdate();
			// Encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public String obterCodigo() {
		String readreserva = "SELECT * from reservas ORDER BY codReserva DESC LIMIT 1";
		String codReserva = null;
		try {
			// Abrir a conexão com o BD
			Connection con = new ConexaoBD().conectar();
			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(readreserva);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				codReserva = rs.getString(1);
			}
			con.close();
			return codReserva;
					
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public void inserirReservaQuarto(Reserva reserva,Quarto quarto) {
		String createreservaquarto = "insert into reserva_quartos(numQuarto, dataInicioReserva, dataFimReserva) values (?,str_to_date(?,'%Y-%m-%d'),str_to_date(?,'%Y-%m-%d'))";
		try {
			// Abrir a conexão com o BD
			Connection con = new ConexaoBD().conectar();
			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(createreservaquarto);
			// Substituir os '?' pelo conteúdo da variável Cliente
			pst.setInt(1, quarto.getNumQuarto());
			pst.setString(2, reserva.getDataInicio());
			pst.setString(3, reserva.getDataFim());
			
			// Executar a query (enviar para o BD)
			pst.executeUpdate();
			// Encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void inserirPagamento(Pagamento pagamento) {
		String createpagamento = "insert into pagamento(formaPagamento, valorTotal) values (?,?)";
		try {
			// Abrir a conexão com o BD
			Connection con = new ConexaoBD().conectar();
			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(createpagamento);
			// Substituir os '?' pelo conteúdo da variável Cliente
			pst.setString(1, pagamento.getFormaPagamento());
			pst.setDouble(2, pagamento.getValorTotal());
			
			// Executar a query (enviar para o BD)
			pst.executeUpdate();
			// Encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean selecionarReserva(Reserva res){
		String readReserva = "SELECT * FROM reservas WHERE codReserva = ?";
		try {
			boolean existe = false;
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(readReserva);
			pst.setInt(1,res.getCodReserva());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				res.setCodReserva(rs.getInt(1));
				res.setCodCli(rs.getString(2));
				res.setDataInicio(rs.getString(3));
				res.setDataFim(rs.getString(4));
				res.setCheckin(rs.getBoolean(5));
				res.setCheckout(rs.getBoolean(6));
				existe = true;
			}
			con.close();
			return existe;
		} catch (Exception e){
			System.out.println(e);
			return false;
		}
	}

	public void deletarReserva(Reserva res){
		String delete = "DELETE FROM reservas WHERE codReserva = ?";
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setInt(1,res.getCodReserva());
			pst.executeUpdate();
			con.close();
		} catch (Exception e){
			System.out.println(e);

		}
	}

	public void fazerCheckin(Reserva res) {
		String checkin = "update reservas set checkin=true where codReserva=?";
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(checkin);
			pst.setInt(1,res.getCodReserva());
			pst.executeUpdate();
			con.close();
		} catch (Exception e){
			System.out.println(e);

		}
	}

	public void fazerCheckout(Reserva res) {
		String checkout = "update reservas set checkout=true where codReserva=?";
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(checkout);
			pst.setInt(1,res.getCodReserva());
			pst.executeUpdate();
			con.close();
		} catch (Exception e){
			System.out.println(e);
		}
	}
}