<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Biblioteca do Lobinho</title>
        <link href='${pageContext.request.contextPath}/css/format.css' rel='stylesheet' />
    </head>
  <body>    
      <form method="post" action='${pageContext.request.contextPath}/Home'>
      <table>             
          <tr>
            <td>Usuário</td>
            <td><input type="text" name="user" size="10" />
            </td>
          </tr>        
          <tr>
            <td>Senha</td>
            <td><input type="password" name="password" size="10" />
            </td>
          </tr>
          <tr>
            <td><button type="submit">Entrar</button></td>
            <td>
            </td>
          </tr>
      </table>
    </form>
  </body>
</html>
