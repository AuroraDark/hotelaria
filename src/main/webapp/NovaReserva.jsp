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
	<link rel="icon" href="assets/favicon.svg" type="image/svg">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
	<link rel="stylesheet" href="styles/style.css">
</head>

<body>
<% if(usuario.getUsuario().equals("admin")){%>
<%@include file="/headerAdmin.jsp" %>
<%}else{%>
<%@include file="/header.jsp" %>
<%}%>

	<form name="frmReserva" action="pagamento">
		<input type="hidden" name="code" value="1">
		<input type="hidden" name="codCli" value="<%out.print(request.getParameter("codCli"));%>">
		<h1>Selecione a data de estadia e o quarto:</h1>
		<table class="consulta">
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
		</table>

		<table border="0" cellspacing="0" cellpadding="0" id="tabela-quartos">
			<thead>
			<tr>
				<th class="id-table">#</th>
				<th>Quarto</th>
				<th>Sobre</th>
				<th class="selecionar-quarto">Escolha</th>
			</tr>
			</thead>
			<% for (int i = 0; i < listaquartos.size();i++){ %>
				<tr>
					<th class="id-table"><%out.print(listaquartos.get(i).getNumQuarto());%></th>
					<td align="center" class="imagem-quarto"><img width="180px" height="126px" src="<%out.print(listaquartos.get(i).getUrlImage());%>"></td>
					<td><h3>Descrição:</h3><p><%out.print(listaquartos.get(i).getDescricao());%></p><br><h3>Valor Diária:</h3><p>R$<%out.print(listaquartos.get(i).getValorDiaria());%></p></td>
					<td class="selecionar-quarto" align="center" ><input type="radio" name="numQuarto" value="<%out.print(listaquartos.get(i).getNumQuarto());%>"></td>
				</tr>
			<%} %>
		</table>
		<input type="button" value="Reservar" class="bttblue" onclick="validarReserva()">
	</form>
	
	<div class="centralizar"><a href="javascript: cancelar()" class="bttred">Cancelar</a></div>
	<script src="scripts/validador.js"></script>
	<script src="scripts/confirmador.js"></script>
</body>
</html>