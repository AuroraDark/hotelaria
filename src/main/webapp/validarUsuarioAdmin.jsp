<%@page import="model.Funcionario" %>
<%
    Funcionario usuario = null;
        if (session.getAttribute("usuario") != null) {
            usuario = (Funcionario) session.getAttribute("usuario");
            if (!(usuario.getUsuario().equals("admin"))) {
                response.sendRedirect("index.jsp");
            }
        } else {
            response.sendRedirect("index.jsp");
        }
%>