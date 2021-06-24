<%@ page language="java" contentType="text/html; utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/validarUsuarioAdmin.jsp"%>
	<!DOCTYPE html>
	<html lang="pt-br">

	<head>
		<meta charset="utf-8">
		<title>Editar Usuário</title>
		<link rel="icon" href="assets/favicon.svg" type="image/svg">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
		<link rel="stylesheet" href="styles/style.css">
	</head>

	<body>
	<%@include file="/headerAdmin.jsp" %>
	
	<form name="formUsuario" action="updateUsuario">
		<h1>Editar Usuário</h1>
		<table>
			<tr>
				<td class="form__group field"><input type="hidden" name="codFunc" id="codFunc" class="form__field"
						readonly value="<%out.print(request.getAttribute("codFunc"));%>"></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="nome" id="nome" class="form__field"
						maxlength="50" value="<%out.print(request.getAttribute("nome"));%>">
					<label for="nome" class="form__label">*Nome Completo</label>
				</td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="email" id="email" maxlength="50"
						class="form__field" value="<%out.print(request.getAttribute("email"));%>">
					<label for="email" class="form__label">*Email</label>
				</td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="cpf" id="cpf" maxlength="11"
						class="form__field" value="<%out.print(request.getAttribute("cpf"));%>">
					<label for="cpf" class="form__label">*CPF</label>
				</td>
			</tr>
			<tr>
				<td class="form__group field"><input type="date" name="dataNasc" id="dataNasc" class="form__field"
						value="<%out.print(request.getAttribute("dataNasc"));%>">
					<label for="dataNasc" class="form__label">*Data de Nascimento</label>
				</td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="cep" id="cep" maxlength="8"
						class="form__field" value="<%out.print(request.getAttribute("cep"));%>">
					<label for="cep" class="form__label">*CEP</label>
				</td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="num" id="num" maxlength="4"
						class="form__field" value="<%out.print(request.getAttribute("numEnd"));%>">
					<label for="num" class="form__label">*Número no Endereço</label>
				</td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="complemento" id="complemento" maxlength="50"
						class="form__field" value="<%out.print((request.getAttribute("complemento").equals("")
						? "N/A" : request.getAttribute("complemento")));%>">
					<label for="complemento" class="form__label">Complemento (Opcional)</label>
				</td>
			</tr>
			<tr>
				<td><br>
					<h2>Dados para Login</h2>
				</td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="usuario" id="usuario" maxlength="30"
						class="form__field" value="<%out.print(request.getAttribute("usuario"));%>">
					<label for="usuario" class="form__label">*Usuário</label>
				</td>
			</tr>
			<tr>
				<td class="form__group field"><input type="password" name="senha" id="senha" maxlength="50"
						class="form__field" value="<%out.print(request.getAttribute("senha"));%>">
					<label for="senha" class="form__label">*Senha</label>
				</td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="bttblue"
			onclick="validarUsuario()">
		<a href="Menu.jsp" class="bttred">Voltar</a>
	</form>
	<script type="text/javascript" src="scripts/validador.js"></script>
</body>
</html>