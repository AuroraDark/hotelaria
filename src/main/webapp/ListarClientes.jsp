<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Cliente" %>
<%@ page import="model.Cartao" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="/validarUsuario.jsp" %>
<%
	ArrayList<Cliente> listaclientes = (ArrayList<Cliente>) request.getAttribute("clientes");
	ArrayList<Cartao> listacartoes = (ArrayList<Cartao>) request.getAttribute("cartoes");
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="utf-8">
	<title>Selecionar Cliente</title>
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

	<h1>Selecione o cliente:</h1>
	<table id="tabela">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>CPF</th>
				<th>Data de Nascimento</th>
				<th>CEP</th>
				<th>Número</th>
				<th>Complemento</th>
				<th>Tipo de Cartão</th>
				<th>Nome no Cartão</th>
				<th>Número do Cartão</th>
				<th>Validade do Cartão</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < listaclientes.size();i++){ %>
				<tr>
					<td><%=listaclientes.get(i).getCodCli() %></td>
					<td><%=listaclientes.get(i).getNome() %></td>
					<td><%=listaclientes.get(i).getFone() %></td>
					<td><%=listaclientes.get(i).getEmail() %></td>
					<td><%=listaclientes.get(i).getCpf() %></td>
					<td><%=listaclientes.get(i).getDataNascimento() %></td>
					<td><%=listaclientes.get(i).getCep() %></td>
					<td><%=listaclientes.get(i).getNumEnd() %></td>
					<td><%=listaclientes.get(i).getComplemento() %></td>
					<td><%=(listacartoes.get(i).getTipo().equals("1") ? "Débito" : "Crédito")%></td>
					<td><%=listacartoes.get(i).getcNome() %></td>
					<td><%=listacartoes.get(i).getcNum() %></td>
					<td><%=listacartoes.get(i).getcVal() %></td>
					<td><a href="selectcliente?codCli=<%=listaclientes.get(i).getCodCli() %>&code=2" class="bttblue">Selecionar</a></td>
				</tr>
				<%} %>
		</tbody>
	</table>
	<a href="ReservaCheck.jsp" class="bttred">Voltar</a>
</body>
</html>