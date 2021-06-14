package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.BasicPasswordEncryptor;

import model.Funcionario;
import model.LoginDAO;
/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns={"/LoginController","/entrar","/sair"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LoginDAO dao = new LoginDAO();
    Funcionario func = new Funcionario();
    BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		if(action.equals("/entrar")) {
			logar(request,response);
		}else {
			response.sendRedirect("Menu.jsp");
		}
	}
	protected void logar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		func.setUsuario(usuario);
		func.setSenha(senha);
		
		
		if(dao.selecionarUsuario(func)) {
			boolean resultado = passwordEncryptor.checkPassword(senha, func.getSenha());

				if(resultado) {
					session.setAttribute("usuario", func);

					if(func.getUsuario().equals("admin")){
						response.sendRedirect("MenuAdmin.jsp");
					} else {
						response.sendRedirect("Menu.jsp");
					}

				}else {
					response.sendRedirect("index.jsp?erro=101");
				}
		}else {
			response.sendRedirect("index.jsp?erro=102");
		}
	}
	
}
