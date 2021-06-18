<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/validarUsuario.jsp" %>
<%
	if(usuario != null){
		if ((usuario.getUsuario().equals("admin"))) {
			response.sendRedirect("MenuAdmin.jsp");
		}
	}
%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<meta charset="utf-8">
	<title>Menu Principal</title>
	<link rel="icon" href="imagens/favicon.png">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
	<link rel="stylesheet" href="styles/style.css">
</head>

<body>
    <%@include file="/header.jsp" %>
	<h1 class="h1-menu">Menu Principal</h1>
	<div class="menu">
	<section class="cards">
		<a href="ReservaCheck.jsp" class="card"><img src="assets/keys.png" alt="sino"><p>Efetuar Reserva</p></a>
		<a href="#" class="card"><img src="assets/lupa.png" alt="lupa"><p>Consultar Reserva</p></a>
		<a href="#" class="card"><img src="assets/entrar.png" alt="entrar"><p>Fazer Check-in</p></a>
		<a href="#" class="card"><img src="assets/sair.png" alt="sair"><p>Fazer Check-out</p></a>
	</section>
</div>
</body>

</html>