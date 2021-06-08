<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.Funcionario"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<Funcionario> lista = (ArrayList<Funcionario>) request.getAttribute("usuarios");
//Teste
/* for (int i = 0; i < lista.size(); i++) {
	out.println(lista.get(i).getIdcon());
	out.println(lista.get(i).getNome());
	out.println(lista.get(i).getFone());
	out.println(lista.get(i).getEmail());

}*/
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
	<table id="tabela">
		<thead>
			<tr>
				<th>Código do funcionário</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Nome de usuário</th>
				<th>Senha</th>
				<th>CPF</th>
				<th>Data de Nascimento</th>
				<th>CEP</th>
				<th>Número</th>
				<th>Complemento</th>
			</tr>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) {%>
			<tr>
				<td><%=lista.get(i).getCodFunc()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><%=lista.get(i).getUsuario()%></td>
				<td><%=lista.get(i).getSenha()%></td>
				<td><%=lista.get(i).getCpf()%></td>
				<td><%=lista.get(i).getDataNascimento()%></td>
				<td><%=lista.get(i).getCep()%></td>
				<td><%=lista.get(i).getNumEnd()%></td>
				<td><%=(lista.get(i).getComplemento().equals("") ? "N/A" : lista.get(i).getComplemento())%></td>
				<td><a href="selectUsuario?codFunc=<%=lista.get(i).getCodFunc()%>"
					class="">Editar</a> 
					<a
					href="javascript: confirmarFuncionario(<%=lista.get(i).getCodFunc()%>)"
					class="">Excluir</a></td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>