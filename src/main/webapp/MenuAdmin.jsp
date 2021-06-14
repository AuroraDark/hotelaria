<%@ page language="java" contentType="text/html; UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/validarUsuarioAdmin.jsp" %>
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
<%@include file="/headerAdmin.jsp" %>
<div class="menu">
    <section class="cards">
        <a href="cadastroUsuario.jsp" class="card"><img src="https://image.flaticon.com/icons/png/512/3112/3112979.png" alt="sino"><p>Cadastrar Usuário</p></a>
        <a href="listarUsuarios" class="card"><img src="https://image.flaticon.com/icons/png/512/3112/3112979.png" alt="sino"><p>Alterar Usuário</p></a>
        <a href="ReservaCheck.jsp" class="card"><img src="https://image.flaticon.com/icons/png/512/3112/3112979.png" alt="sino"><p>Efetuar Reserva</p></a>
        <a href="#" class="card"><img src="https://image.flaticon.com/icons/png/512/639/639375.png" alt="lupa"><p>Consultar Reserva</p></a>
        <a href="#" class="card"><img src="https://image.flaticon.com/icons/png/512/1828/1828466.png" alt="entrar"><p>Fazer Check-in</p></a>
        <a href="#" class="card"><img src="https://image.flaticon.com/icons/png/512/1828/1828490.png" alt="sair"><p>Fazer Check-out</p></a>
    </section>
</div>
</body>

</html>