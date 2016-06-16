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
	<%
		Usuario cad = new Usuario();
		UsuarioDAO dao = new UsuarioDAO();

		if (request.getMethod().equalsIgnoreCase("POST")) {

			if (request.getParameter("cadastrar") != null) {
				pageBean.cadastrar();
				response.sendRedirect("Cadastro.jsp");
			}

			if (request.getParameter("alteracao") != null) {
				System.out.println(pageBean.getId());
				pageBean.atualizar();

			}
		}

		if (request.getParameter("excluir") != null) {
			pageBean.excluir(request.getParameter("excluir"));
			response.sendRedirect("Cadastro.jsp");
		}
	%>


	<div class="container">

		<h3>Cadastro do Usuário</h3>

		<form action="Cadastro.jsp" method="post">
			<input type="hidden" name="cadastrar" value="true">
			<p>
				ID : <input type="text" name="id" value="<%=dao.getLastId() + 1%>">
			</p>
			<p>
				Digite o Nome: <input type="text" name="nome" required="required" />
			</p>
			<p>
				Digite o e-mail: <input type="text" name="email" required="required" />
			</p>
			<p>
				Digite o CPF: <input type="text" name="cpf" required="required" />
			</p>

			<input type="submit" class="btn btn-success" value="Cadastrar">

		</form>

		<br /> <br />

		<div class="container">
			<h2>Usuarios no banco de dados</h2>
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Email</th>
						<th>CPF</th>
						<th>Alterar</th>

					</tr>
				</thead>
				<tbody>
					<%
						for (Usuario user : dao.getLista()) {
					%>

					<tr>
						<td><%=user.getId()%></td>
						<td><%=user.getNome()%></td>
						<td><%=user.getEmail()%></td>
						<td><%=user.getCpf()%></td>
						<td>
							<form action="Cadastro2.jsp" method="post">
								<input type="hidden" name="alterar" value="<%=user.getId()%>" />
								<button class="btn btn-warning">Alterar</button>
							</form>
						</td>

					</tr>
					<%
						}
					%>


				</tbody>
			</table>
		</div>
	</div>


</body>
</html>