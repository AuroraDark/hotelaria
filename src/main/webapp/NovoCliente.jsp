<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/validarUsuario.jsp" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<title>Novo Cliente</title>
	<link rel="icon" href="assets/favicon.svg" type="image/svg">
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

	<form name="frmCliente" action="createcliente">
		<h1>Novo Cliente</h1>
		<input type="hidden" name="redir" value="<%out.print(request.getParameter("redir"));%>">
		<table>
			<tr>
				<td class="form__group field"><input type="text" name="nome"
					placeholder="Nome" maxlength="50" class="form__field"><label
					for="nome" class="form__label">*Nome</label></td>

			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="fone"
					placeholder="Telefone" maxlength="15" class="form__field"><label
					for="fone" class="form__label">*Telefone</label></td>

			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="email"
					placeholder="E-mail" maxlength="50" class="form__field"><label
					for="email" class="form__label">*Email</label></td>

			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="cpf"
					placeholder="CPF" maxlength="11" class="form__field"><label
					for="cpf" class="form__label">*CPF</label></td>

			</tr>
			<tr>
				<td class="form__group field"><input type="date"
					name="dataNascimento" class="form__field"><label
					for="dataNascimento" class="form__label">*Data de Nascimento</label></td>

			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="cep"
					placeholder="CEP" maxlength="8" class="form__field"><label
					for="cep" class="form__label">*CEP</label></td>

			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="numEnd"
					placeholder="Número" maxlength="4" class="form__field"><label
					for="numEnd" class="form__label">*Número no Endereço</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text"
					name="complemento" placeholder="Complemento" maxlength="50"
					class="form__field"><label for="complemento"
					class="form__label">Complemento (Opcional)</label></td>

			</tr>
			<tr>
				<td><br>
					<h2>Dados de Pagamento</h2></td>
			</tr>
			<tr>
				<td class="form__group field"><label for="tipo"
					class="label-select">*Tipo de Cartão</label> <select name="tipo">
						<option value="">Selecionar</option>
						<option value="1">Débito</option>
						<option value="2">Crédito</option>
				</select></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="cNome"
					placeholder="Nome no Cartão" maxlength="50" class="form__field"><label
					for="cNome" class="form__label">*Nome no Cartão</label></td>

			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="cNum"
					placeholder="Número do Cartão" maxlength="16" class="form__field"><label
					for="cNum" class="form__label">*Número do Cartão</label></td>

			</tr>
			<tr>
				<td class="form__group field"><input type="date" name="cVal"
					maxlength="50" class="form__field"><label for="cVal"
					class="form__label">*Validade</label></td>

			</tr>
		</table>
		<input type="button" value="Enviar" class="bttblue"
			onclick="validarCliente()">
		<a href="Menu.jsp" class="bttred">Voltar</a>
	</form>
	<script src="scripts/validador.js"></script>
</body>