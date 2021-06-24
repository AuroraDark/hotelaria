<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/validarUsuario.jsp" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Fazer Check-in</title>
    <link rel="icon" href="assets/favicon.svg" type="image/svg">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    <link rel="stylesheet" href="styles/style.css">
</head>
<body>
<%@include file="/header.jsp" %>
<%
    String sucesso = request.getParameter("sucesso");
    if(sucesso != null){
        out.write("<div class=\"centralizar\"><p class=\"sucesso\">Check-in realizado com sucesso!</p></div>");
    }

    String erro = request.getParameter("erro");
    if (erro != null) {
        if (erro.equals("301")) {
            out.write("<div class=\"centralizar\"><p class=\"erro\">Reserva não existe, por favor insira uma reserva válida.</p></div>");
        }else if(erro.equals("302")){
            out.write("<div class=\"centralizar\"><p class=\"erro\">Esta reserva não possui um cliente associado a ela.</p></div>");
        }
    }
%>
<form name="frmCReserva" action="ConsultarReservaCheckin">
    <h1>Fazer Check-in</h1>
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

<% if(request.getAttribute("codReserva")!=null) {
    if(request.getAttribute("checkin").equals(false)){%>
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
            <th>Check-in</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th><%=request.getAttribute("codReserva")%></th>
            <td><%=request.getAttribute("nome")%></td>
            <td><%=request.getAttribute("cpf")%></td>
            <td><%=request.getAttribute("dataInicio")%></td>
            <td><%=request.getAttribute("dataFim")%></td>
            <td><a href="checkin?codReserva=<%=request.getAttribute("codReserva")%>"
               class="bttblue">Check-in</a></td>
        </tr>
        </tbody>
    </table>
</section>
<div class="centralizar"><a href="Menu.jsp" class="bttred">Voltar</a></div>
<%}else {
    out.write("<div class=\"centralizar\"><p class=\"erro\">Check-in já foi realizado para esta reserva.</p></div>");
}
}%>
</body>
</html>
