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
	<title>Listar Usuários</title>
	<link rel="icon" href="imagens/favicon.png">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
	<link rel="stylesheet" href="styles/style.css">
</head>

<body>
<%@include file="/headerAdmin.jsp" %>

	<table id="tabela">
		<thead>
			<tr>
				<th>Código do funcionário</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Nome de usuário</th>
				<th>Senha</th>
				<th>CPF</th>
				<th>Data de Nascimento</th>
				<th>CEP</th>
				<th>Número</th>
				<th>Complemento</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) {%>
			<tr>
				<td><%=lista.get(i).getCodFunc()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getUsuario()%></td>
				<td><%=lista.get(i).getSenha()%></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td><%=lista.get(i).getDataNascimento()%></td>
				<td><%=lista.get(i).getCep()%></td>
				<td><%=lista.get(i).getNumEnd()%></td>
				<td><%=(lista.get(i).getComplemento().equals("") ? "N/A" : lista.get(i).getComplemento())%></td>
				<td><a href="selectUsuario?codFunc=<%=lista.get(i).getCodFunc()%>"
					class="">Editar</a> 
					<a
					href="javascript: confirmarFuncionario(<%=lista.get(i).getCodFunc()%>)"
					class="">Deletar</a></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<a href="Menu.jsp" class="bttred">Voltar</a>
	<script src="scripts/confirmador.js"></script>
</body>
</html>