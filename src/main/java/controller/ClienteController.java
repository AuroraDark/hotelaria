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
import model.QuartoDAO;
import model.Cliente;
import model.Quarto;
import model.Cartao;

@WebServlet(urlPatterns = { "/Controller", "/main", "/createcliente", "/readcliente", "/selectcliente", "/updatecliente", "/deletecliente"})
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClienteDAO dao = new ClienteDAO();
	QuartoDAO daoq = new QuartoDAO();
	Cliente cliente = new Cliente();
	Quarto quarto = new Quarto();
	Cartao cartao = new Cartao();
	
	public ClienteController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/main")) {
			response.sendRedirect("Menu.jsp");
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
			response.sendRedirect("Menu.jsp");
		}
	}
	
	//Cadastrar Cliente
	protected void efetuarCadastroCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redir = request.getParameter("redir");
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
		
		if(redir.equals("1")) {
			response.sendRedirect("main");
		}else {
			response.sendRedirect("readcliente?code=2");
		}
	}
	
	//Listar Clientes
	protected void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String code = request.getParameter("code");
		ArrayList<Cliente> listaclientes = dao.listarClientes();
		ArrayList<Cartao> listacartoes = dao.listarCartoes();

		request.setAttribute("clientes",listaclientes);
		request.setAttribute("cartoes", listacartoes);
		if(code.equals("1")) {
			RequestDispatcher rd = request.getRequestDispatcher("SelecionarCliente.jsp");
			rd.forward(request, response);
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("ListarClientes.jsp");
			rd.forward(request, response);
		}
	}
	
	//Listar o cliente a ser editado
	protected void exibirCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codCli = request.getParameter("codCli");
		String code = request.getParameter("code");
		
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
		
		if(code.equals("1")){
			RequestDispatcher rd = request.getRequestDispatcher("EditarCliente.jsp");
			rd.forward(request, response);
		}else {
			ArrayList<Quarto> listaquartos = daoq.listarQuartos();
			request.setAttribute("quartos", listaquartos);
			RequestDispatcher rd = request.getRequestDispatcher("NovaReserva.jsp");
			rd.forward(request, response);
		}
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
		
		response.sendRedirect("readcliente?code=1");
	}
	
	//Remover Clientes
	protected void deletarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String codCli = request.getParameter("CodCli");
		cliente.setCodCli(codCli);
		cartao.setCodCli(codCli);
		
		dao.deletarCliente(cliente);
		dao.deletarCartao(cartao);
		
		response.sendRedirect("readcliente?code=1");
	}
}