package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FuncionarioDAO {

	/*CRUD INSERT*/
	public void inserirFuncionario(Funcionario func) {
		String create = "INSERT INTO funcionarios (nome,email,usuario,senha,CPF,dataNascimento,CEP,numEnd,complemento) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, func.getNome());
			pst.setString(2, func.getEmail());
			pst.setString(3, func.getUsuario());
			pst.setString(4, func.getSenha());
			pst.setString(5, func.getCpf());
			pst.setString(6, func.getDataNascimento());
			pst.setString(7, func.getCep());
			pst.setString(8, func.getNumEnd());
			pst.setString(9, func.getComplemento());
			
			pst.executeUpdate();
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
	/*CRUD READ*/
	public ArrayList<Funcionario> listarUsuarios(){
		ArrayList<Funcionario> listaUsuarios = new ArrayList<>();
		String read = "SELECT * FROM funcionarios ORDER BY nome";
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {//a cada linha
				String codFunc = rs.getString(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String usuario = rs.getString(4);
				String senha = rs.getString(5);
				String cpf = rs.getString(6);
				String dataNascimento = rs.getString(7);
				String cep = rs.getString(8);
				String numEnd= rs.getString(9);
				String complemento = rs.getString(10);
				
				listaUsuarios.add(new Funcionario(codFunc,nome,email,usuario,senha,cpf,dataNascimento,cep,numEnd,complemento));//add a cada linha
			}
			con.close();
			return listaUsuarios;	
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/*CRUD UPDATE*/
	public boolean selecionarUsuario(Funcionario func) {
		String readUsuario = "SELECT * FROM funcionarios WHERE codFunc = ?";
		try {
			boolean resultado = false;
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(readUsuario);
			pst.setString(1, func.getCodFunc());
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
				resultado=true;
			}
			con.close();
			return resultado;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public void alterarUsuario(Funcionario func) {
		// TODO Auto-generated method stub
		String update = "UPDATE funcionarios SET nome=?,email=?,usuario=?,senha=?,CPF=?,dataNascimento=?,CEP=?,numEnd=?,complemento=? WHERE codFunc=?";
		
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(update);
			pst.setString(1, func.getNome());
			pst.setString(2, func.getEmail());
			pst.setString(3, func.getUsuario());
			pst.setString(4, func.getSenha());
			pst.setString(5, func.getCpf());
			pst.setString(6, func.getDataNascimento());
			pst.setString(7, func.getCep());
			pst.setString(8, func.getNumEnd());
			pst.setString(9, func.getComplemento());
			pst.setString(10, func.getCodFunc());
			
			pst.executeUpdate();//Nada é retornado a nao ser valores de status
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*CRUD DELETE*/
	public void deletarFuncionario(Funcionario func) {
		String delete = "DELETE FROM funcionarios WHERE codFunc=?";
		
		try {
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, func.getCodFunc());
			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/*Verificar Nome de usuário*/
	public boolean selecionarNomeUsuario(String usuario) {
		String readUsuario = "SELECT * FROM funcionarios WHERE usuario = ?";
		try {
			boolean existe = false;
			Connection con = new ConexaoBD().conectar();
			PreparedStatement pst = con.prepareStatement(readUsuario);
			pst.setString(1, usuario);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
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