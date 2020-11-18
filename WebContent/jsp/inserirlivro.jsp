<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='${pageContext.request.contextPath}/css/format.css' rel='stylesheet' />
<title>Biblioteca do Lobinho</title>
</head>
<body>
	<jsp:include page="/header.jsp" flush="true">
		<jsp:param value="${user}" name="usuario"/>
	</jsp:include> <br><br>
	<H3>Insira os Dados do Livro</H3><br>
	<form method="post" action="${pageContext.request.contextPath}/inserirLivro">
		Nome: <input type="text" name="nome">
		Ano: <input type="text" name="ano">
		Autor: <input type="text" name="autor">
		<input type="submit" value="Inserir Livro">
	</form>
	<br><br><button onclick="goBack()">Voltar</button>
	<script>
	function goBack() {
	  window.history.go(-1);
	}
	</script>
</body>
</html>