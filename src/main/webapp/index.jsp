<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel</title>
</head>
<body>
    <form name="formLogin" method="post" action="entrar">
        <table>
            <h1>Login</h1>
            <tr>
                <td class="form__group field"><input type="text" name="usuario" placeholder="Usuário" class="form__field"></td>
            </tr>
            <%
			String erro = request.getParameter("erro");
			if (erro != null) {
				if (erro.equals("101")) {
					out.write("<p>Senha incorreta</p>");
				}
			}
			%> 
            <tr>
                <td class="form__group field"><input type="password" name="senha" placeholder="Senha" class="form__field"></td>
            </tr>
            <%
			if (erro != null) {
				if (erro.equals("102")) {
					out.write("<p>Usuário não existe</p>");
				}
			}
			%>
            <tr>
                <td><a href="#">Esqueceu sua senha?</a></td>
            </tr>
        </table>
        <input type="button" value="Entrar" class="bttblue" onclick="validarLogin()">
    </form>
    <script src="scripts/validador.js"></script>
</body>
</html>