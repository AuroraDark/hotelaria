package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasypt.util.password.BasicPasswordEncryptor;

import model.Funcionario;
import model.FuncionarioDAO;

/**
 * Servlet implementation class FuncionarioController
 */
@WebServlet(urlPatterns = { "/FuncionarioController", "/CadastroUsuario", "/listarUsuarios", "/selectUsuario", "/updateUsuario","/deleteUsuario" })
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FuncionarioDAO dao = new FuncionarioDAO();
	Funcionario func = new Funcionario();
	BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FuncionarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		response.setCharacterEncoding("UTF-8");
		if (action.equals("/listarUsuarios")) {
			funcionarios(request, response);
		} else if (action.equals("/selectUsuario")) {
			listarFuncionarios(request, response);
		}else if (action.equals("/updateUsuario")) {
			editarUsuario(request,response);
		}else if (action.equals("/deleteUsuario")) {
			deletarUsuario(request,response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath(); 
		response.setCharacterEncoding("UTF-8");
		if (action.equals("/CadastroUsuario")) {
			inserirFunc(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	protected void inserirFunc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String usuario = request.getParameter("usuario");
		if(dao.selecionarNomeUsuario(usuario)) {
			response.sendRedirect("cadastroUsuario.jsp?erro=201");
		}else{
			String senhaCriptografada = passwordEncryptor.encryptPassword(request.getParameter("senha"));
			func.setNome(request.getParameter("nome"));
			func.setCpf(request.getParameter("cpf"));
			func.setEmail(request.getParameter("email"));
			func.setDataNascimento(request.getParameter("dataNasc"));
			func.setCep(request.getParameter("cep"));
			func.setNumEnd(request.getParameter("num"));
			func.setComplemento(request.getParameter("complemento"));
			func.setUsuario(request.getParameter("usuario"));
			func.setSenha(senhaCriptografada);

			dao.inserirFuncionario(func);
			//response.setCharacterEncoding("UTF-8");
			response.sendRedirect("listarUsuarios");
		}
	}

	protected void funcionarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Funcionario> listaUsuarios = dao.listarUsuarios();
		/* Teste de recebimento */
		/*for (int i = 0; i < listaUsuarios.size(); i++) {
			System.out.println(listaUsuarios.get(i).getCodFunc());
			System.out.println(listaUsuarios.get(i).getNome());
			System.out.println(listaUsuarios.get(i).getEmail());
			System.out.println(listaUsuarios.get(i).getUsuario());
			System.out.println(listaUsuarios.get(i).getSenha());
			System.out.println(listaUsuarios.get(i).getCep());
			System.out.println(listaUsuarios.get(i).getCpf());
			System.out.println(listaUsuarios.get(i).getNumEnd());
			System.out.println(listaUsuarios.get(i).getComplemento());
		}*/
		// Encaminhando lista para agenda.jsp(Encaminhar objeto a uma página)
		request.setAttribute("usuarios", listaUsuarios);
		RequestDispatcher rd = request.getRequestDispatcher("ListarUsuarios.jsp");// seto a página
		rd.forward(request, response);// executa

	}

	private void listarFuncionarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codFunc = request.getParameter("codFunc");
		func.setCodFunc(codFunc);
		// Executar selecionarContato (DAO)
		dao.selecionarUsuario(func);// puxar dados correspondentes do BD

		request.setAttribute("codFunc", func.getCodFunc());
		request.setAttribute("nome", func.getNome());
		request.setAttribute("email", func.getEmail());
		request.setAttribute("usuario", func.getUsuario());
		request.setAttribute("senha", func.getSenha());
		request.setAttribute("cpf", func.getCpf());
		request.setAttribute("dataNasc", func.getDataNascimento());
		request.setAttribute("cep", func.getCep());
		request.setAttribute("numEnd", func.getNumEnd());
		request.setAttribute("complemento", func.getComplemento());

		RequestDispatcher rd = request.getRequestDispatcher("EditarUsuario.jsp");
		rd.forward(request, response);
	}
	
	private void editarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String senhaCriptografada = passwordEncryptor.encryptPassword(request.getParameter("senha"));
		/*System.out.println(request.getParameter("codFunc"));
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("cpf"));
		System.out.println(request.getParameter("dataNasc"));
		System.out.println(request.getParameter("cep"));
		System.out.println(request.getParameter("num"));
		System.out.println(request.getParameter("complemento"));
		System.out.println(request.getParameter("usuario"));*/
		
		func.setCodFunc(request.getParameter("codFunc"));
		func.setNome(request.getParameter("nome"));
		func.setEmail(request.getParameter("email"));
		func.setUsuario(request.getParameter("usuario"));
		func.setSenha(senhaCriptografada);
		func.setCpf(request.getParameter("cpf"));
		func.setDataNascimento(request.getParameter("dataNasc"));
		func.setCep(request.getParameter("cep"));
		func.setNumEnd(request.getParameter("num"));
		func.setComplemento(request.getParameter("complemento"));

		dao.alterarUsuario(func);
		// redireciona a listaUsuarios.jsp)
		response.sendRedirect("listarUsuarios");
	}
	
	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id(confirmador.js)
		String codFunc = request.getParameter("codfunc");
		func.setCodFunc(codFunc);
		// executar deletarContato(dao)
		dao.deletarFuncionario(func);
		response.sendRedirect("listarUsuarios");
	}

}
