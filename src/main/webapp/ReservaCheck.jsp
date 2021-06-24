<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Funcionario" %>
<%@include file="/validarUsuario.jsp" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="utf-8">
	<title>Efetuar Reserva</title>
	<link rel="icon" href="assets/favicon.svg" type="image/svg">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
	<link rel="stylesheet" href="styles/style.css">
</head>

<body class="reserva-check">

<% if(usuario.getUsuario().equals("admin")){%>
<%@include file="/headerAdmin.jsp" %>
<%}else{%>
<%@include file="/header.jsp" %>
<%}%>
<h1 class="h1-menu">Efetuar Reserva</h1>
<div class="menu">
	<section class="cards">
    <a href="NovoCliente.jsp?redir=2" class="card"><img src="assets/add-user.png" alt="add-user"><p>Novo Cliente</p></a>
	<a href="readcliente?code=2" class="card"><img src="assets/user.png" alt="user"><p>Cliente existente</p></a>
	</section>
</div>
<a href="Menu.jsp" class="bttred">Voltar</a>
</body>
</html>