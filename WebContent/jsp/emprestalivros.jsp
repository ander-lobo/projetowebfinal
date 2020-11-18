<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Biblioteca do Lobinho</title>
        <meta charset='UTF-8'>
        <link href='${pageContext.request.contextPath}/css/format.css' rel='stylesheet' />
    </head>
    <body>
    <jsp:include page="/header.jsp" flush="true">
		<jsp:param value="${user}" name="usuario"/>
	</jsp:include> <br><br>
	
        <H3>Livros Disponíveis</H3>
        <table>
            <TR class='tituloCampo'>
                <TD>Id</TD>
                <TD>Nome</TD>
                <TD>Autor</TD>
                <TD>Ano</TD>
                
            </TR>
            <c:forEach var="livros" items="${livros}">
                <TR>
                	<TD class='gridCampo'>${livros.id}</TD>
                	<TD class='gridCampo'>${livros.nome}</TD>
                    <TD class='gridCampo'>${livros.autor}</TD>
                    <TD class='gridCampo'>${livros.ano}</TD>
                    
                </TR>
            </c:forEach>
            <TR>
            	<TD>
            	<form method="post" action='${pageContext.request.contextPath}/emprestaLivros'>
				<label for="id">Digite o Id do livro desejado: </label>
				<input type="number" id="id" name="id">
				<input type="submit" value="Solicitar">
				</form>
				</TD>
			</TR>
			<TR><TD>
           <br><br><button onclick="goBack()">Voltar</button>
			<script>
			function goBack() {
			  window.history.go(-1);
			}
			</script>
            </TD></TR>
        </table>
    </body>
</html>
