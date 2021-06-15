<%@page import="model.Funcionario" %>
<% 
	Funcionario usuario = null;
	if(session.getAttribute("usuario") != null){	
		usuario = (Funcionario) session.getAttribute("usuario");
	}else{
		response.sendRedirect("index.jsp");
	}

%>