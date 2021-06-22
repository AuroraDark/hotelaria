<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/validarUsuarioAdmin.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Consultar Reserva</title>
    <link rel="icon" href="imagens/favicon.png">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
    <%@include file="/headerAdmin.jsp" %>
    <%
        String erro = request.getParameter("erro");
        if (erro != null) {
            if (erro.equals("301")) {
                out.write("<p>Reserva não existe, por favor insira uma reserva válida</p>");
            }else if(erro.equals("302")){
                out.write("<p>Esta reserva não possui um cliente associado a ela</p>");
            }
        }
    %>
    <form name="frmCReserva" action="ConsultarReserva">
        <h1>Consultar Reserva</h1>
        <label for="cReserva">Insira o número da reserva:</label>
        <input type="text" name="cReserva" id="cReserva" value="<%if(request.getAttribute("codReserva")!=null) { out.print(request.getAttribute("codReserva"));}%>">
        <input type="submit" value="Buscar">
    </form>
    <% if(request.getAttribute("codReserva")!=null) {%>
        <table border="0" cellspacing="0" cellpadding="0" id="tabela">
            <thead>
            <tr>
                <th>Código da reserva</th>
                <th>Nome</th>
                <th>CPF</th>
                <th>Data de entrada</th>
                <th>Data de saída</th>
                <th>Opções</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><%=request.getAttribute("codReserva")%></td>
                <td><%=request.getAttribute("nome")%></td>
                <td><%=request.getAttribute("cpf")%></td>
                <td><%=request.getAttribute("dataInicio")%></td>
                <td><%=request.getAttribute("dataFim")%></td>
                <td><a href="javascript: confirmarReserva(<%=request.getAttribute("codReserva")%>)"
                       class="bttred" style="font-size: 20px; color: white;">Cancelar</a>
                    <a href="Menu.jsp" class="bttblue" style="font-size: 20px; color: white;"><i class="fas fa-pen"></i>OK</a></td>
            </tr>
            </tbody>
        </table>
    <%}%>
<script src="scripts/confirmador.js"></script>
</body>
</html>
