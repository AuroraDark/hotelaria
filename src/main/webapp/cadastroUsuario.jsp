<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/validarUsuarioAdmin.jsp" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<title>Cadastrar Usuário</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<link rel="stylesheet" href="styles/style.css">
</head>

<body>

<%@include file="/headerAdmin.jsp" %>

	<form name="formUsuario" method="post" action="CadastroUsuario">
		<h1>Crie sua conta (Funcionário)</h1>
		<table>
			<tr>
				<td>
					<h2>Dados Pessoais</h2>
				</td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="nome"
					placeholder="Nome" maxlength="50" class="form__field"> <label
					for="nome" class="form__label">*Nome</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="cpf"
					required="required" placeholder="CPF" maxlength="11"
					class="form__field" pattern="[0-9]+$"><label for="cpf"
					class="form__label">*CPF</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="email" name="email"
					placeholder="Email" maxlength="50" class="form__field"> <label
					for="email" class="form__label">*Email</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="date"
					name="dataNasc" placeholder="Data de Nascimento"
					class="form__field"><label for="dataNasc"
					class="form__label">*Data de Nascimento</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="cep"
					required="required" placeholder="CEP" maxlength="8"
					class="form__field" pattern="[0-9]+$"><label for="cep"
					class="form__label">*CEP</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="num"
					placeholder="Número" maxlength="4" class="form__field"> <label
					for="num" class="form__label">*Número</label></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text"
					name="complemento" placeholder="Complemento" maxlength="50"
					class="form__field"><label for="complemento"
					class="form__label">*Complemento</label></td>
			<tr>
				<td><br>
					<h2>Dados para Login</h2></td>
			</tr>
			<tr>
				<td class="form__group field"><input type="text" name="usuario"
					maxlength="30" placeholder="Usuário" class="form__field"> <label
					for="usuario" class="form__label">*Usuário</label></td>
			</tr>
			<%
				String erro = request.getParameter("erro");
				if (erro != null) {
					if (erro.equals("201")) {
						out.write("<p>Nome de usuário já existe, escolha outro usuário</p>");
					}
				}
			%>
			<tr>
				<td class="form__group field"><input type="password"
					name="senha" maxlength="50" placeholder="Senha" class="form__field">
					<label for="senha" class="form__label">*Senha</label></td>
			</tr>
		</table>
		<input type="button" value="Cadastrar" class="bttblue"
			onclick="validarUsuario()">
		<a href="Menu.jsp" class="bttred">Voltar</a>
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>