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
	
	Livro ${requestScope.nome} não cadastrado, verifique os dados e tente novamente.
	
	<br><form method="get" action="jsp/inserirlivro.jsp">
	<input type="submit" value="Voltar">
	</form>
</body>
</html>