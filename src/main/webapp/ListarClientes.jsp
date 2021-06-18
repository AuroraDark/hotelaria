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
	<meta name="viewport" content="width=device-width, initial-scale=1">
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

<div class="centralizar"><h1>Selecione o Cliente</h1></div>
<section class="centralizar">
	<table border="0" cellspacing="0" cellpadding="0" id="tabela">
		<thead>
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>CPF</th>
				<th>Tipo de Cartão</th>
				<th class="edicao">Selecionar</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < listaclientes.size();i++){ %>
				<tr>
					<th><%=listaclientes.get(i).getCodCli() %></th>
					<td><%=listaclientes.get(i).getNome() %></td>
					<td><%=listaclientes.get(i).getFone() %></td>
					<td><%=listaclientes.get(i).getCpf() %></td>
					<td><%=(listacartoes.get(i).getTipo().equals("1") ? "Débito" : "Crédito")%></td>
					<td class="edicao"><a href="selectcliente?codCli=<%=listaclientes.get(i).getCodCli()%>&code=2" class="bttblue">Selecionar</a></td>
				</tr>
				<%} %>
		</tbody>
	</table>
</section>
<div class="centralizar"><a href=ReservaCheck.jsp" class="bttred">Voltar</a></div>
</body>
</html>