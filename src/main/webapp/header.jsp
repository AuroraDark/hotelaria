<%@ page language="java" pageEncoding="UTF-8"%>
<header>
    <nav class="dropdown">
        <button class="dropbtn"style="font-size: 24px; color: white;"><i class="fas fa-bars"></i></button>
        <div class="dropdown-content">
            <a href="NovoCliente.jsp?redir=1" >Cadastrar Cliente</a>
            <a href="readcliente?code=1">Alterar Cliente</a>
            <a href="ReservaCheck.jsp">Efetuar Reserva</a>
            <a href="#">Consultar Reserva</a>
            <a href="#">Fazer Check-in</a>
            <a href="#">Fazer Check-out</a>
        </div>
    </nav>
    <div class="info-user"><p>Olá, <span><%=usuario.getNome() %></span></p><a href="sair.jsp" class="bttred">Sair</a></div>
</header>