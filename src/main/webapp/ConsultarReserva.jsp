<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/validarUsuario.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Consultar Reserva</title>
    <link rel="icon" href="assets/favicon.svg" type="image/svg">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
    <%@include file="/header.jsp" %>
    <%
        String erro = request.getParameter("erro");
        if (erro != null) {
            if (erro.equals("301")) {
                out.write("<div class=\"centralizar\"><p class=\"erro\">Reserva não existe, por favor insira uma reserva válida.</p></div>");
            }else if(erro.equals("302")){
                out.write("<div class=\"centralizar\"><p class=\"erro\">Esta reserva não possui um cliente associado a ela.</p></div>");
            }
        }
    %>
    <form name="frmCReserva" action="ConsultarReserva">
        <h1>Consultar Reserva</h1>
        <table class="consulta">
            <tr>
                <td class="form__group field">
                    <input class="form__field" type="text" name="cReserva" id="cReserva" placeholder="Número da Reserva" value="<%if(request.getAttribute("codReserva")!=null) { out.print(request.getAttribute("codReserva"));}%>">
                    <label class="form__label" for="cReserva">Número da Reserva</label>
                </td>
            </tr>
        </table>
        <input type="submit" value="Buscar" class="bttblue">
    </form>

    <% if(request.getAttribute("codReserva")!=null) {%>
    <div class="centralizar"><h1>Resultado:</h1></div>
    <section class="centralizar">
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
                       class="bttred" style="font-size: 20px; color: white;"><i class="fas fa-trash-alt"></i></a>
            </tr>
            </tbody>
        </table>
    </section>
    <div class="centralizar"><a href="Menu.jsp" class="bttred">Voltar</a></div>
    <%}%>

    <script src="scripts/confirmador.js"></script>
</body>
</html>
