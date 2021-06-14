<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Cliente" %>
<%@ page import="model.Cartao" %>
<%@ page import="model.Quarto" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="/validarUsuario.jsp" %>
<%
	ArrayList<Quarto> listaquartos = (ArrayList<Quarto>) request.getAttribute("quartos");
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="utf-8">
	<title>Nova Reserva</title>
	<link rel="icon" href="imagens/favicon.png">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
	<link rel="stylesheet" href="styles/style.css">
</head>

<body>
<% if(usuario.getUsuario().equals("admin")){%>
<%@include file="/headerAdmin.jsp" %>
<%}else{%>
<%@include file="/header.jsp" %>
<%}%>

	<form name="frmReserva" action="">
		<input type="hidden" name="codCli" value="<%out.print(request.getParameter("codCli"));%>">
		<h1>Selecione a data de estadia e o quarto:</h1>
		<table>
			<tr>
				<td class="form__group field"><input type="date"
					name="dataInicio" class="form__field"><label
					for="dataInicio" class="form__label">Check-In</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="date"
					name="dataFim" class="form__field"><label
					for="dataFim" class="form__label">Check-Out</label></td>

			</tr>
			<% for (int i = 0; i < listaquartos.size();i++){ %>
				<tr>
					<td>
						<input type="radio" name="numQuarto" value="<%out.println(listaquartos.get(i).getNumQuarto());%>">
						<label for="Quarto <%out.println(listaquartos.get(i).getNumQuarto());%>">
						Quarto <%out.println(listaquartos.get(i).getNumQuarto());%>:<br>
						<%out.println(listaquartos.get(i).getDescricao());%><br>
						Valor da diária: <%out.println(listaquartos.get(i).getValorDiaria());%></label><br>
					</td>
				</tr>
			<%} %>
		</table>
		<input type="button" value="Reservar" class="bttblue" onclick="validarReserva()">
	</form>
	<!-- TESTE DE RECEBIMENTO -->
	Teste de recebimento:
	<%out.print(request.getAttribute("nome")); %><br>
	<%out.print(request.getAttribute("fone")); %><br>
	<%out.print(request.getAttribute("email")); %><br>
	<%out.print(request.getAttribute("cpf")); %><br>
	<%out.print(request.getAttribute("dataNascimento")); %><br>
	<%out.print(request.getAttribute("cep")); %><br>
	<%out.print(request.getAttribute("numEnd")); %><br>
	<%out.print(request.getAttribute("complemento")); %><br>
	
	<%for (int i = 0; i < listaquartos.size();i++){
		out.println(listaquartos.get(i).getNumQuarto());
		out.println(listaquartos.get(i).getDescricao());
		out.println(listaquartos.get(i).getValorDiaria());
		out.println(listaquartos.get(i).isStatusDisp());
		}%>
	<br><br><br><br>
	<a href="javascript: cancelar()" class="bttred">Cancelar</a>
	<script src="scripts/validador.js"></script>
	<script src="scripts/confirmador.js"></script>
</body>
</html>