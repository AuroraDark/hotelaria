package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ClienteDAO {
	
	/** CRUD CREATE **/
	public void inserirCliente(Cliente cliente) {
		String createcliente = "insert into clientes(nome,fone,email,CPF,dataNascimento,CEP,numEnd,complemento) values (?,?,?,?,str_to_date(?,'%Y-%m-%d'),?,?,?)";
		try {
			// Abrir a conexão com o BD
			Connection con = new ConexaoBD().conectar();
			// Preparar a query para execução no BD
			PreparedStatement pst = con.prepareStatement(createcliente);
			// Substituir os '?' pelo conteúdo da variável Cliente
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getFone());
			pst.setString(3, cliente.getEmail());
			pst.setString(4, cliente.getCpf());
			pst.setString(5, cliente.getDataNascimento());
			pst.setString(6, cliente.getCep());
			pst.setString(7, cliente.getNumEnd());
			pst.setString(8, cliente.getComplemento());
			// Executar a query (enviar para o BD)
			pst.executeUpdate();
			// Encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void inserirCartao(Cartao cartao) {
		
		String createcartao = "insert into cartao(tipo,cNome,cNum,cVal) values(?,?,?,str_to_date(?,'%Y-%m-%d'))";
		try {
			// Abrir a conexão com o BD
			Connection con = new ConexaoBD().conectar();
			// Preparar a query para execução no BD
			PreparedStatement pstc = con.prepareStatement(createcartao);
			// Substituir os '?' pelo conteúdo da variável Cartao
			pstc.setString(1, cartao.getTipo());
			pstc.setString(2, cartao.getcNome());
			pstc.setString(3, cartao.getcNum());
			pstc.setString(4, cartao.getcVal());
			// Executar a query (enviar para o BD)
			pstc.executeUpdate();
			// Encerrar a conexão
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** CRUD READ **/
	public ArrayList<Cliente> listarClientes() {
		// Criar um objeto pra acessar o Cliente
		ArrayList<Cliente> listaclientes = new ArrayList<>();
		String readcliente = "select * from clientes order by codCli";
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(readcliente);
			ResultSet rs = pst.executeQuery();
			// Enquanto houver contatos
			while (rs.next()) {
				// Variáveis temporárias pra receber os dados
				String codcli = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				String cpf = rs.getString(5);
				String datanasc = rs.getString(6);
				String cep = rs.getString(7);
				String numend = rs.getString(8);
				String comp = rs.getString(9);
				// Colocar tudo no Array
				listaclientes.add(new Cliente(codcli,nome,fone,email,cpf,datanasc,cep,numend,comp));
			}
			con.close();
			return listaclientes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public ArrayList<Cartao> listarCartoes() {
		ArrayList<Cartao> listacartoes = new ArrayList<>();
		String readcartao = "select * from cartao order by codCli";
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pstc = con.prepareStatement(readcartao);
			ResultSet rsc = pstc.executeQuery();
			// Enquanto houver contatos
			while (rsc.next()) {
				// Variáveis temporárias pra receber os dados
				String codcli = rsc.getString(1);
				String tipo = rsc.getString(2);
				String cnome = rsc.getString(3);
				String cnum = rsc.getString(4);
				String cval = rsc.getString(5);
				// Colocar tudo no Array
				listacartoes.add(new Cartao(codcli,tipo,cnome,cnum,cval));
			}
			con.close();
			return listacartoes;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	/** CRUD UPDATE
	 * @return**/
	//Selecionar o contato
		public boolean selecionarCliente(Cliente cliente) {
			String readcliente2 = "select * from clientes where codCli = ?";
			try {
				boolean existe = false;
				Connection con = new ConexaoBD().conectar();
				PreparedStatement pst = con.prepareStatement(readcliente2);
				pst.setString(1, cliente.getCodCli());
				ResultSet rs = pst.executeQuery();
				while(rs.next()) {
					//Setar a variável Cliente
					cliente.setCodCli(rs.getString(1));
					cliente.setNome(rs.getString(2));
					cliente.setFone(rs.getString(3));
				    cliente.setEmail(rs.getString(4));
				    cliente.setCpf(rs.getString(5));
				    cliente.setDataNascimento(rs.getString(6));
				    cliente.setCep(rs.getString(7));
				    cliente.setNumEnd(rs.getString(8));
				    cliente.setComplemento(rs.getString(9));
				    existe = true;
				}
				con.close();
				return existe;
			} catch (Exception e) {
				System.out.println(e);
				return false;
			}
		}
		
		public void selecionarCartao(Cartao cartao) {
			String readcartao2 = "select * from cartao where codCli = ?";
			try {
				Connection con = new ConexaoBD().conectar();
				PreparedStatement pstc = con.prepareStatement(readcartao2);
				pstc.setString(1, cartao.getCodCli());
				ResultSet rsc = pstc.executeQuery();
				while(rsc.next()) {
					//Setar a variável Cartão
					 cartao.setCodCli(rsc.getString(1));
					 cartao.setTipo(rsc.getString(2));
					 cartao.setcNome(rsc.getString(3));
					 cartao.setcNum(rsc.getString(4));
					 cartao.setcVal(rsc.getString(5));
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		//Editar o contato
		public void alterarCliente(Cliente cliente) {
			String updatecliente = "update clientes set nome=?,fone=?,email=?,CPF=?,dataNascimento=str_to_date(?,'%Y-%m-%d'),CEP=?,numEnd=?,complemento=? where codCli=?";
			try {
				Connection con = new ConexaoBD().conectar();
				PreparedStatement pst = con.prepareStatement(updatecliente);
				pst.setString(1, cliente.getNome());
				pst.setString(2, cliente.getFone());
				pst.setString(3, cliente.getEmail());
				pst.setString(4, cliente.getCpf());
				pst.setString(5, cliente.getDataNascimento());
				pst.setString(6, cliente.getCep());
				pst.setString(7, cliente.getNumEnd());
				pst.setString(8, cliente.getComplemento());
				pst.setString(9, cliente.getCodCli());
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void alterarCartao(Cartao cartao) {
			String updatecartao = "update cartao set tipo=?,cNome=?,cNum=?,cVal=str_to_date(?,'%Y-%m-%d') where codCli=?";
			try {
				Connection con = new ConexaoBD().conectar();
				PreparedStatement pstc = con.prepareStatement(updatecartao);
				pstc.setString(1, cartao.getTipo());
				pstc.setString(2, cartao.getcNome());
				pstc.setString(3, cartao.getcNum());
				pstc.setString(4, cartao.getcVal());
				pstc.setString(5, cartao.getCodCli());
				pstc.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		/** CRUD DELETE**/
		public void deletarCliente(Cliente cliente) {
			String deletecliente = "delete from clientes where CodCli=?";
			try {
				Connection con = new ConexaoBD().conectar();
				PreparedStatement pst = con.prepareStatement(deletecliente);
				pst.setString(1, cliente.getCodCli());
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void deletarCartao(Cartao cartao) {
			String deletecartao = "delete from cartao where CodCli=?";
			try {
				Connection con = new ConexaoBD().conectar();
				PreparedStatement pstc = con.prepareStatement(deletecartao);
				pstc.setString(1,cartao.getCodCli());
				pstc.executeUpdate();
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
}
