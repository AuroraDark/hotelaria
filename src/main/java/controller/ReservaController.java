package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cartao;
import model.Cliente;
import model.ClienteDAO;
import model.Quarto;
import model.QuartoDAO;
import model.Reserva;
import model.ReservaDAO;
import model.Pagamento;

/**
 * Servlet implementation class ReservaController
 */
@WebServlet(urlPatterns = {"/ReservaController","/ConsultarReserva","/DeleteReserva","/pagamento","/ConsultarReservaCheckin", "/ConsultarReservaCheckout", "/checkin", "/checkout"})
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cartao cartao = new Cartao();
	Cliente cliente = new Cliente();
	ClienteDAO dao = new ClienteDAO();
	Quarto quarto = new Quarto();
	QuartoDAO daoq = new QuartoDAO();
	Reserva reserva = new Reserva();
	ReservaDAO daor = new ReservaDAO();
	Pagamento pagamento = new Pagamento();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservaController() {
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
		if (action.equals("/pagamento")) {
			try {
				efetuarPagamento(request, response);
			} catch (ServletException | IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (action.equals("/ConsultarReserva")) {
			consultarReserva(request,response);
		}else if (action.equals("/DeleteReserva")) {
			deletarReserva(request,response);
		}else if (action.equals("/checkin")) {
			checkin(request,response);
		}else if (action.equals("/checkout")) {
			checkout(request,response);
		}else if (action.equals("/ConsultarReservaCheckin")) {
			consultarReservaCheckin(request,response);
		}else if (action.equals("/ConsultarReservaCheckout")) {
			consultarReservaCheckout(request,response);
		} else {
			response.sendRedirect("Menu.jsp");
		}
	}
	
	protected void efetuarPagamento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String code = request.getParameter("code");
		if(code.equals("1")) {
			cartao.setCodCli(request.getParameter("codCli"));
			reserva.setDataInicio(request.getParameter("dataInicio"));
			reserva.setDataFim(request.getParameter("dataFim"));
			quarto.setNumQuarto(Integer.parseInt(request.getParameter("numQuarto")));
			
			dao.selecionarCartao(cartao);
			daoq.selecionarQuarto(quarto);
			
			long temporeserva = calcularTempoReserva(reserva.getDataFim(), reserva.getDataInicio());
			
			double valorTotal = quarto.getValorDiaria()*temporeserva;
			String valorTotalString = new DecimalFormat("R$#.00").format(valorTotal);
			String valor2Parcelas = new DecimalFormat("R$#.00").format((quarto.getValorDiaria()*temporeserva)/2);
			String valor3Parcelas = new DecimalFormat("R$#.00").format((quarto.getValorDiaria()*temporeserva)/3);
			
			request.setAttribute("dataInicio",reserva.getDataInicio());
			request.setAttribute("dataFim",reserva.getDataFim());
			request.setAttribute("temporeserva", temporeserva);
			request.setAttribute("valorTotal", valorTotal);
			request.setAttribute("valorTotalS",valorTotalString);
			request.setAttribute("valor2Parcelas", valor2Parcelas);
			request.setAttribute("valor3Parcelas", valor3Parcelas);
			request.setAttribute("tipo",cartao.getTipo());
			request.setAttribute("cNome",cartao.getcNome());
			request.setAttribute("cNum",cartao.getcNum());
			request.setAttribute("cVal",cartao.getcVal());
			request.setAttribute("numQuarto", quarto.getNumQuarto());
			request.setAttribute("valorDiaria",quarto.getValorDiaria());
			request.setAttribute("codCli",cartao.getCodCli());
			
			RequestDispatcher rd = request.getRequestDispatcher("Pagamento.jsp");
			rd.forward(request, response);
		} else {
			reserva.setCodCli(request.getParameter("codCli"));
			reserva.setDataInicio(request.getParameter("dataInicio"));
			reserva.setDataFim(request.getParameter("dataFim"));
			quarto.setNumQuarto(Integer.parseInt(request.getParameter("numQuarto")));
			pagamento.setFormaPagamento(request.getParameter("formaPagamento"));
			pagamento.setValorTotal(Double.parseDouble(request.getParameter("valorTotal")));
			
			daor.inserirReserva(reserva);
			daor.inserirReservaQuarto(reserva,quarto);
			daor.inserirPagamento(pagamento);
			
			String codigo = daor.obterCodigo();
			
			request.setAttribute("codReserva",codigo);
			
			RequestDispatcher rd = request.getRequestDispatcher("ReservaFinalizada.jsp");
			rd.forward(request, response);
		}
	
	}

	private long calcularTempoReserva(String dataFim, String dataInicio) throws ParseException {
		Date d1 = new SimpleDateFormat("yyyy-M-dd").parse((String) reserva.getDataFim());
		Date d2 = new SimpleDateFormat("yyyy-M-dd").parse((String) reserva.getDataInicio());
		long diff = Math.abs(d1.getTime() - d2.getTime());
		long diffdays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		if(diffdays==0) {
			diffdays=1;
		}
		return diffdays;
	}
		
	private void consultarReserva(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cReserva = Integer.parseInt(request.getParameter("cReserva"));
		reserva.setCodReserva(cReserva);
		System.out.println(reserva.toString());
			if(daor.selecionarReserva(reserva)) {
				request.setAttribute("codReserva",reserva.getCodReserva());
				request.setAttribute("codCli",reserva.getCodCli());
				request.setAttribute("dataInicio",reserva.getDataInicio());
				request.setAttribute("dataFim",reserva.getDataFim());
				request.setAttribute("checkin",reserva.isCheckin());
				request.setAttribute("checkout",reserva.isCheckout());
				System.out.println(reserva.toString());
				cliente.setCodCli(reserva.getCodCli());
				if(dao.selecionarCliente(cliente)){
					request.setAttribute("nome", cliente.getNome());
					request.setAttribute("cpf",cliente.getCpf());
					RequestDispatcher rd = request.getRequestDispatcher("ConsultarReserva.jsp");
					rd.forward(request, response);
				}else{
					response.sendRedirect("ConsultarReserva.jsp?erro=302");
				}
			}else{
				response.sendRedirect("ConsultarReserva.jsp?erro=301");
			}
	}

	private void consultarReservaCheckin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cReserva = Integer.parseInt(request.getParameter("cReserva"));
		reserva.setCodReserva(cReserva);
		System.out.println(reserva.toString());
		if(daor.selecionarReserva(reserva)) {
			request.setAttribute("codReserva",reserva.getCodReserva());
			request.setAttribute("codCli",reserva.getCodCli());
			request.setAttribute("dataInicio",reserva.getDataInicio());
			request.setAttribute("dataFim",reserva.getDataFim());
			request.setAttribute("checkin",reserva.isCheckin());
			request.setAttribute("checkout",reserva.isCheckout());
			System.out.println(reserva.toString());
			cliente.setCodCli(reserva.getCodCli());
			if(dao.selecionarCliente(cliente)){
				request.setAttribute("nome", cliente.getNome());
				request.setAttribute("cpf",cliente.getCpf());
				RequestDispatcher rd = request.getRequestDispatcher("Checkin.jsp");
				rd.forward(request, response);
			}else{
				response.sendRedirect("Checkin.jsp?erro=302");
			}
		}else{
			response.sendRedirect("Checkin.jsp?erro=301");
		}
	}

	private void consultarReservaCheckout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cReserva = Integer.parseInt(request.getParameter("cReserva"));
		reserva.setCodReserva(cReserva);
		System.out.println(reserva.toString());
		if(daor.selecionarReserva(reserva)) {
			request.setAttribute("codReserva",reserva.getCodReserva());
			request.setAttribute("codCli",reserva.getCodCli());
			request.setAttribute("dataInicio",reserva.getDataInicio());
			request.setAttribute("dataFim",reserva.getDataFim());
			request.setAttribute("checkin",reserva.isCheckin());
			request.setAttribute("checkout",reserva.isCheckout());
			System.out.println(reserva.toString());
			cliente.setCodCli(reserva.getCodCli());
			if(dao.selecionarCliente(cliente)){
				request.setAttribute("nome", cliente.getNome());
				request.setAttribute("cpf",cliente.getCpf());
				RequestDispatcher rd = request.getRequestDispatcher("Checkout.jsp?");
				rd.forward(request, response);
			}else{
				response.sendRedirect("Checkout.jsp?erro=302");
			}
		}else{
			response.sendRedirect("Checkout.jsp?erro=301");
		}
	}
	private void deletarReserva(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id(confirmador.js)
		int codReserva = Integer.parseInt(request.getParameter("codReserva"));
		reserva.setCodReserva(codReserva);
		daor.deletarReserva(reserva);
		response.sendRedirect("ConsultarReserva.jsp");
	}

	private void checkin(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

			int codReserva = Integer.parseInt(request.getParameter("codReserva"));
			reserva.setCodReserva(codReserva);
			daor.fazerCheckin(reserva);
			response.sendRedirect("Checkin.jsp?sucesso=1");
	}

	private void checkout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int codReserva = Integer.parseInt(request.getParameter("codReserva"));
		reserva.setCodReserva(codReserva);
		daor.fazerCheckout(reserva);
		response.sendRedirect("Checkout.jsp?sucesso=1");
	}
}