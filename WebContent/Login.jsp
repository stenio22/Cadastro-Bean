<%@page import="java.sql.Connection"%>
<%@page import="controller.ConnectionFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario</title>
</head>
<body>

	<%
		ConnectionFactory conn = new ConnectionFactory();
		Connection conexao = conn.getConnection();
		if(conexao != null){
			out.println("Conexão OK");
		}else{
			out.println("Erro na conexão");
		}

	
	%>

	<form name='formulario' method='post' action='Controlador'>
		<table border='1'>
			<tr align='center'>
				<td colspan='2'>Entre com o login</td>
			</tr>
			<tr>
				<td>Login</td>
				<td><input type='text' name='login' /></td>
			</tr>
			<tr>
				<td>Senha</td>
				<td><input type='password' name='senha'> <input
					type="hidden" name="acao" value="Autenticar"></td>
			</tr>
			<tr>
				<td colspan=2 align='center'>
				<input type='submit' name='submeter' value='Enviar' /> 
				<input type='reset'	name='submeter' value='Limpar' /></td>
			</tr>
		</table>
	</form>

</body>
</html>