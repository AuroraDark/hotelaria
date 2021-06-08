package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ClienteDAO;
import model.Cliente;
import model.Cartao;

@WebServlet(urlPatterns = { "/Controller", "/main", "/createcliente", "/readcliente", "/selectcliente", "/updatecliente", "/deletecliente"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO dao = new ClienteDAO();
	Cliente cliente = new Cliente();
	Cartao cartao = new Cartao();
	
	public ClienteController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/main")) {
			response.sendRedirect("Menu.html");
		}else if(action.equals("/createcliente")) {
			efetuarCadastroCliente(request,response);
		}else if(action.equals("/readcliente")) {
			listarClientes(request,response);
		}else if(action.equals("/selectcliente")){
			exibirCliente(request,response);
		}else if(action.equals("/updatecliente")){
			alterarCliente(request,response);
		}else if(action.equals("/deletecliente")) {
			deletarCliente(request,response);
		}else {
			response.sendRedirect("Menu.html");
		}
	}
	
	//Cadastrar Cliente
	protected void efetuarCadastroCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cliente.setNome(request.getParameter("nome"));
		cliente.setFone(request.getParameter("fone"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setDataNascimento(request.getParameter("dataNascimento"));
		cliente.setCep(request.getParameter("cep"));
		cliente.setNumEnd(request.getParameter("numEnd"));
		cliente.setComplemento(request.getParameter("complemento"));
		cartao.setTipo(request.getParameter("tipo"));
		cartao.setcNome(request.getParameter("cNome"));
		cartao.setcNum(request.getParameter("cNum"));
		cartao.setcVal(request.getParameter("cVal"));
		
		dao.inserirCliente(cliente);
		dao.inserirCartao(cartao);
		
		response.sendRedirect("main");
	}
	
	//Listar Clientes
	protected void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<Cliente> listaclientes = dao.listarClientes();
		ArrayList<Cartao> listacartoes = dao.listarCartoes();

		request.setAttribute("clientes",listaclientes);
		request.setAttribute("cartoes", listacartoes);
		RequestDispatcher rd = request.getRequestDispatcher("SelecionarCliente.jsp");
		rd.forward(request, response);
	}
	
	//Listar o cliente a ser editado
	protected void exibirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codCli = request.getParameter("codCli");
		
		cliente.setCodCli(codCli);
		cartao.setCodCli(codCli);
		
		dao.selecionarCliente(cliente);
		dao.selecionarCartao(cartao);
		
		request.setAttribute("codCli", cliente.getCodCli());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("fone", cliente.getFone());
		request.setAttribute("email", cliente.getEmail());
		request.setAttribute("cpf", cliente.getCpf());
		request.setAttribute("dataNascimento", cliente.getDataNascimento());
		request.setAttribute("cep", cliente.getCep());
		request.setAttribute("numEnd", cliente.getNumEnd());
		request.setAttribute("complemento", cliente.getComplemento());
		request.setAttribute("tipo", cartao.getTipo());
		request.setAttribute("cNome", cartao.getcNome());
		request.setAttribute("cNum", cartao.getcNum());
		request.setAttribute("cVal", cartao.getcVal());
		
		RequestDispatcher rd = request.getRequestDispatcher("EditarCliente.jsp");
		rd.forward(request, response);
	}
	
	//Editar Clientes
	protected void alterarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		cliente.setCodCli(request.getParameter("codCli"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setFone(request.getParameter("fone"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setCpf(request.getParameter("cpf"));
		cliente.setDataNascimento(request.getParameter("dataNascimento"));
		cliente.setCep(request.getParameter("cep"));
		cliente.setNumEnd(request.getParameter("numEnd"));
		cliente.setComplemento(request.getParameter("complemento"));
		cartao.setCodCli(request.getParameter("codCli"));
		cartao.setTipo(request.getParameter("tipo"));
		cartao.setcNome(request.getParameter("cNome"));
		cartao.setcNum(request.getParameter("cNum"));
		cartao.setcVal(request.getParameter("cVal"));
		
		dao.alterarCliente(cliente);
		dao.alterarCartao(cartao);
		
		response.sendRedirect("readcliente");
	}
	
	//Remover Clientes
	protected void deletarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String codCli = request.getParameter("CodCli");
		cliente.setCodCli(codCli);
		cartao.setCodCli(codCli);
		
		dao.deletarCliente(cliente);
		dao.deletarCartao(cartao);
		
		response.sendRedirect("readcliente");
	}
}
