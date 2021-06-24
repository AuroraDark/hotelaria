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
<div class="centralizar"><h1>Editar Clientes</h1></div>
<section class="centralizar">
	<table border="0" cellspacing="0" cellpadding="0" id="tabela">
		<thead>
			<tr>
				<th>#</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>CPF</th>
				<th>Tipo de Cartão</th>
				<th class="edicao">Edição</th>
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
					<td class="edicao"><a href="selectcliente?codCli=<%=listaclientes.get(i).getCodCli() %>&code=1" class="bttblue" style="font-size: 20px; color: white;"><i class="fas fa-pen"></i></a><a href="javascript: confirmarCliente(<%=listaclientes.get(i).getCodCli() %>)" class="bttred" style="font-size: 20px; color: white;"><i class="fas fa-trash-alt"></i></a></td>
				</tr>
				<%} %>
		</tbody>
	</table>
</section>
<script src="scripts/confirmador.js"></script>
<div class="centralizar"><a href="Menu.jsp" class="bttred">Voltar</a></div>
</body>
</html>