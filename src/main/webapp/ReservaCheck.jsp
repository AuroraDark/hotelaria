<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Funcionario" %>
<%@include file="/validarUsuario.jsp" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="utf-8">
	<title>Efetuar Reserva</title>
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

    <a href="NovoCliente.jsp?redir=2" class="bttblue">Novo Cliente</a>
	<a href="readcliente?code=2" class="bttblue">Cliente existente</a>
	<a href="Menu.jsp" class="bttred">Voltar</a>
</body>
</html>