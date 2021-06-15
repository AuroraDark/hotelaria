<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Funcionario"%>
<%@ page import="java.util.ArrayList"%>
<%@ include file="/validarUsuarioAdmin.jsp"%>
<%
ArrayList<Funcionario> lista = (ArrayList<Funcionario>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Listar Usuários</title>
	<link rel="icon" href="imagens/favicon.png">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
	<link rel="stylesheet" href="styles/style.css">
</head>

<body>
<%@include file="/headerAdmin.jsp" %>

	<div class="centralizar"><h1>Editar Usuários</h1></div>

	<section class="centralizar">
	<table border="0" cellspacing="0" cellpadding="0" id="tabela">
		<thead>
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th>Nome de usuário</th>
				<th>CPF</th>
				<th class="edicao">Edição</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) {%>
			<tr>
				<th><%=lista.get(i).getCodFunc()%></th>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getUsuario()%></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td class="edicao"><a href="selectUsuario?codFunc=<%=lista.get(i).getCodFunc()%>"
					class="bttblue" style="font-size: 20px; color: white;"><i class="fas fa-pen"></i></a>
					<a
					href="javascript: confirmarFuncionario(<%=lista.get(i).getCodFunc()%>)"
					class="bttred" style="font-size: 20px; color: white;"><i class="fas fa-trash-alt"></i></a></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	</section>
<div class="centralizar"><a href="Menu.jsp" class="bttred">Voltar</a></div>
	<script src="scripts/confirmador.js"></script>
</body>
</html>