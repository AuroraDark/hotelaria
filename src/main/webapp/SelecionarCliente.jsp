<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="model.Cliente" %>
<%@ page import="model.Cartao" %>
<%@ page import="java.util.ArrayList" %>
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
	<header>
		<nav class="dropdown">
			<button class="dropbtn"style="font-size: 24px; color: white;"><i class="fas fa-bars"></i></button>
			<div class="dropdown-content">
				<a href="NovoCliente.html" >Cadastrar Cliente</a>
				<a href="readcliente">Alterar Cliente</a>
				<a href="#">Efetuar Reserva</a>
				<a href="#">Consultar Reserva</a>
				<a href="#">Fazer Check-in</a>
				<a href="#">Fazer Check-out</a>
			</div>
		</nav>
		<div class="info-user"><p>Olá, <span>Usuário</span></p><a href="#" class="bttred">Sair</a></div>
	</header>
	<h1>Selecione um cliente para Alterar:</h1>
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
					<td><%=listacartoes.get(i).getTipo() %></td>
					<td><%=listacartoes.get(i).getcNome() %></td>
					<td><%=listacartoes.get(i).getcNum() %></td>
					<td><%=listacartoes.get(i).getcVal() %></td>
					<td><a href="selectcliente?codCli=<%=listaclientes.get(i).getCodCli() %>" class="bttblue">Editar</a><a href="javascript: confirmarCliente(<%=listaclientes.get(i).getCodCli() %>)" class="bttred">Deletar</a></td>
				</tr>
				<%} %>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
	<a href="Menu.html" class="bttblue">Voltar</a>
</body>
</html>