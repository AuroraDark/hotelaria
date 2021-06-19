package controller;

import java.io.IOException;
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
import model.ClienteDAO;
import model.Quarto;
import model.QuartoDAO;
import model.Reserva;
import model.ReservaDAO;
import model.Pagamento;

/**
 * Servlet implementation class ReservaController
 */
@WebServlet(urlPatterns = {"/ReservaController", "/pagamento"})
public class ReservaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Cartao cartao = new Cartao();
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
			double valor2Parcelas = valorTotal/2;
			double valor3Parcelas = valorTotal/3;
			
			request.setAttribute("dataInicio",reserva.getDataInicio());
			request.setAttribute("dataFim",reserva.getDataFim());
			request.setAttribute("temporeserva", temporeserva);
			request.setAttribute("valorTotal", valorTotal);
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
			
			RequestDispatcher rd = request.getRequestDispatcher("ReservaFinalizada.jsp");
			rd.forward(request, response);
		}
	
	}

	private long calcularTempoReserva(String dataFim, String dataInicio) throws ParseException {
		Date d1 = new SimpleDateFormat("yyyy-M-dd").parse((String) reserva.getDataFim());
		Date d2 = new SimpleDateFormat("yyyy-M-dd").parse((String) reserva.getDataInicio());
		long diff = Math.abs(d1.getTime() - d2.getTime());
		long diffdays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		return diffdays;
	}
		
}