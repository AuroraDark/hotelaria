<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/validarUsuario.jsp" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<title>Pagamento</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<link rel="stylesheet" href="styles/style.css">
</head>

<body>
<% if(usuario.getUsuario().equals("admin")){%>
<%@include file="/headerAdmin.jsp" %>
<%}else{%>
<%@include file="/header.jsp" %>
<%}%>

	<h1>Insira os dados de pagamento:</h1>
	<form name="frmPagamento" action="pagamento">
		<input type="hidden" name="code" value="2">
		<input type="hidden" name="codCli" value="<%out.print(request.getAttribute("codCli"));%>">
		<input type="hidden" name="dataInicio" value="<%out.print(request.getAttribute("dataInicio"));%>">
		<input type="hidden" name="dataFim" value="<%out.print(request.getAttribute("dataFim"));%>">
		<input type="hidden" name="numQuarto" value="<%out.print(request.getAttribute("numQuarto"));%>">
		<input type="hidden" name="valorTotal" value="<%out.print(request.getAttribute("valorTotal"));%>">
		<table>
			<tr>
				<td class="form__group field"><input type="text"
					name="tipo" class="form__field" readonly value="<%=(request.getAttribute("tipo").equals("1") ? "Débito" : "Crédito")%>"><label
					for="tipo" class="form__label">*Tipo de Cartão</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text"
					name="cNome" class="form__field" readonly value="<%out.print(request.getAttribute("cNome"));%>"><label
					for="cNome" class="form__label">*Nome no Cartão</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text"
					name="cVal" class="form__field" readonly value="<%out.print(request.getAttribute("cVal"));%>"><label
					for="cVal" class="form__label">*Validade</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text"
					name="cNum" class="form__field" readonly value="<%out.print(request.getAttribute("cNum"));%>"><label
					for="cNum" class="form__label">*Número do Cartão</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="password"
					name="cvv" maxlength="3" class="form__field"><label
					for="cvv" class="form__label">*CVV</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text"
					name="valorTotalS" class="form__field" readonly value="<%out.print(request.getAttribute("valorTotalS"));%>"><label
					for="valorTotalS" class="form__label">Valor Total:</label></td>
			</tr>
			<tr>
				<td class="form__group field"><label for="formaPagamento"
					class="label-select">*Forma de parcelamento</label> <select name="formaPagamento">
						<option value="">Selecionar</option>
						<option value="<%=(request.getAttribute("tipo").equals("1") ? "Débito" : "Crédito")%> - 1 parcela de <%out.print(request.getAttribute("valorTotalS"));%>">1 parcela de R$<%out.print(request.getAttribute("valorTotalS"));%></option>
						<option value="<%=(request.getAttribute("tipo").equals("1") ? "Débito" : "Crédito")%> - 2 parcelas de <%out.print(request.getAttribute("valor2Parcelas"));%>">2 parcelas de <%out.print(request.getAttribute("valor2Parcelas"));%></option>
						<option value="<%=(request.getAttribute("tipo").equals("1") ? "Débito" : "Crédito")%> - 3 parcelas de <%out.print(request.getAttribute("valor3Parcelas"));%>">3 parcelas de <%out.print(request.getAttribute("valor3Parcelas"));%></option>
				</select></td>
			</tr>
		</table>
		<input type="button" value="Efetuar Reserva" class="bttblue"
			onclick="validarPagamento()">
	</form>
	<a href="javascript: cancelar()" class="bttred">Cancelar</a>
	<script src="scripts/validador.js"></script>
	<script src="scripts/confirmador.js"></script>
</body>
</html>