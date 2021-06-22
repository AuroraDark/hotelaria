<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/validarUsuario.jsp" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<title>Reserva Finalizada</title>
<link rel="icon" href="imagens/favicon.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
<link rel="stylesheet" href="styles/style.css">
</head>

<body>
<% if(usuario.getUsuario().equals("admin")){%>
<%@include file="/headerAdmin.jsp" %>
<%}else{%>
<%@include file="/header.jsp" %>
<%}%>
	
	Reserva efetuada com sucesso!
	
	<a href="Menu.jsp" class="bttred">Voltar</a>
	
</body>
</html>