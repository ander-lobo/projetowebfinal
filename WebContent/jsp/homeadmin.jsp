<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href='${pageContext.request.contextPath}/css/format.css' rel='stylesheet' />
<title>Biblioteca do Lobinho</title>
</head>
<body>
	<jsp:include page="/header.jsp" flush="true">
		<jsp:param value="${user}" name="usuario"/>
	</jsp:include> <br><br>
	
	<br><form method="get" action="jsp/inserirlivro.jsp">
	Clique aqui caso deseje inserir um livro no banco de dados: <input type="submit" value="Inserir Livros">
	</form><br>
	<br><form method="get" action="catalogoLivros">
	Clique aqui caso deseje consultar a lista de livros: <input type="submit" value="Consultar Livros">
	</form><br>
	<br><form method="get" action="consultaEmprestimos">
	Clique aqui caso deseje consultar os seus empréstimos: <input type="submit" value="Consultar Livros Emprestados">
	</form><br>
	<br><form method="get" action="emprestaLivros">
	Clique aqui caso deseje realizar um empréstimo: <input type="submit" value="Solicitar Livros">
	</form><br>
	<br><form method="get" action="devolveLivros">
	Clique aqui caso deseje devolver os seus empréstimos: <input type="submit" value="Devolver Livros">
	</form><br>
	
	<br><form method="post" action='${pageContext.request.contextPath}/login.jsp'>
	<input type="submit" value="Logout">
	</form>

</body>
</html>