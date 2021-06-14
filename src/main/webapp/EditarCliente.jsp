<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/validarUsuario.jsp" %>
	<!DOCTYPE html>
	<html lang="pt-br">

	<head>
		<meta charset="utf-8">
		<title>Editar Cliente</title>
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

		<form name="frmCliente" action="updatecliente">
			<h1>Editar Cliente</h1>
			<table>
				<tr>
					<td><input type="hidden" name="codCli" value="<%out.print(request.getAttribute("codCli")); %>">
					</td>
				</tr>
				<tr>
					<td class="form__group field"><input type="text" name="nome" class="form__field" maxlength="50"
							value="<%out.print(request.getAttribute("nome")); %>"><label for="nome"
							class="form__label">Nome</label></td>

				</tr>
				<tr>
					<td class="form__group field"><input type="text" name="fone" class="form__field" maxlength="15"
							value="<%out.print(request.getAttribute("fone")); %>"><label for="fone"
							class="form__label">Telefone</label></td>

				</tr>
				<tr>
					<td class="form__group field"><input type="text" name="email" class="form__field" maxlength="50"
							value="<%out.print(request.getAttribute("email")); %>"><label for="email"
							class="form__label">Email</label></td>

				</tr>
				<tr>
					<td class="form__group field"><input type="text" name="cpf" class="form__field" maxlength="11"
							value="<%out.print(request.getAttribute("cpf")); %>"><label for="cpf"
							class="form__label">CPF</label></td>

				</tr>
				<tr>
					<td class="form__group field"><input type="date" name="dataNascimento" class="form__field"
							value="<%out.print(request.getAttribute("dataNascimento")); %>"><label for="dataNascimento"
							class="form__label">Data de Nascimento</label></td>

				</tr>
				<tr>
					<td class="form__group field"><input type="text" name="cep" class="form__field" maxlength="8"
							value="<%out.print(request.getAttribute("cep")); %>"><label for="cep"
							class="form__label">CEP</label></td>

				</tr>
				<tr>
					<td class="form__group field"><input type="text" name="numEnd" class="form__field" maxlength="4"
							value="<%out.print(request.getAttribute("numEnd")); %>"><label for="numEnd"
							class="form__label">Número do Endereço</label></td>

				</tr>
				<tr>
					<td class="form__group field"><input type="text" name="complemento" class="form__field"
							maxlength="50" value="<%out.print(request.getAttribute("complemento")); %>"><label
							for="complemento" class="form__label">Complemento</label></td>

				</tr>
				<tr>
					<td><br>
						<h2>Dados de Pagamento</h2>
					</td>
				</tr>
				<tr>
					<td class="form__group field"><input type="text" name="tipo" class="form__field" maxlength="1"
							value="<%out.print(request.getAttribute("tipo")); %>"><label for="tipo"
							class="form__label">Tipo de Cartão (1 - Débito | 2 - Crédito)</label></td>

				</tr>
				<tr>
					<td class="form__group field"><input type="text" name="cNome" class="form__field" maxlength="50"
							value="<%out.print(request.getAttribute("cNome")); %>"><label for="cNome"
							class="form__label">Nome no Cartão</label></td>

				</tr>
				<tr>
					<td class="form__group field"><input type="text" name="cNum" class="form__field" maxlength="16"
							value="<%out.print(request.getAttribute("cNum")); %>"><label for="cNum"
							class="form__label">Número do Cartão</label></td>

				</tr>
				<tr>
					<td class="form__group field"><input type="date" name="cVal" class="form__field"
							value="<%out.print(request.getAttribute("cVal")); %>"><label for="cVal"
							class="form__label">Validade</label></td>

				</tr>
			</table>
			<input type="button" value="Salvar" class="bttblue" onclick="validarCliente()">
			<a href="readcliente?code=1" class="bttred">Voltar</a>
		</form>
		<script src="scripts/validador.js"></script>
	</body>

	</html>