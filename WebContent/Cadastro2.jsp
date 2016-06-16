<%@page import="controller.Usuario"%>
<%@page import="controller.UsuarioDAO"%>
<jsp:useBean id="pageBean" class="controller.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="pageBean" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Cadastro de Usuários</title>
</head>
<body>



	<div class="container">


		<br /> <br />


			<%
				if(request.getParameter("alterar") != null){
			Usuario userAlt = pageBean.retornaUsuario(request.getParameter("alterar"));
			
			%>
			
			<h3>Alteração de Usuário</h3>

			<form action="Cadastro.jsp" method="post" >
				<input type="hidden" name="alteracao" value="true">
				<p>ID : <input type="text" name="id" value="<%=userAlt.getId()%>"></p>
				<p>Digite o Nome: <input type="text" name="nome" value="<%=userAlt.getNome()%>" required="required"/></p>
				<p>Digite o e-mail: <input type="text" name="email" value="<%=userAlt.getEmail()%>" required="required"/></p>
				<p>Digite o CPF: <input type="text" name="cpf" value="<%=userAlt.getCpf()%>"required="required"/></p>
	
				<input type="submit" class="btn btn-info" value="Alterar">
	
					
			<%
		}
			%>
			</form>
		</div>




		<div class="container">
			<h2>Usuarios no banco de dados</h2>
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Email</th>
						<th>CPF</th>
						<th>Excluir</th>
					</tr>
				</thead>
				<tbody>
					<%
						UsuarioDAO dao = new UsuarioDAO();
						for (Usuario user : dao.getLista()) {
					%>

					<tr>
						<td><%=user.getId()%></td>
						<td><%=user.getNome()%></td>
						<td><%=user.getEmail()%></td>
						<td><%=user.getCpf() %></td>
						<td><form action="Cadastro.jsp" method="post">
								<input type="hidden" name="excluir" value="<%=user.getId()%>" />
								<button class="btn btn-danger">Excluir</button>
							</form></td>
					</tr>
					<%
						}
					%>


				</tbody>
			</table>
		</div>




</body>
</html>