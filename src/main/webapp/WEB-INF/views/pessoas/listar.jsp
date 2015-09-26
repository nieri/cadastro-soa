<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
  <head>
    <title>Lista de Pessoas</title>
  </head>
  <body>
  <div><h1>Lista de Pessoas</h1></div>
    <c:forEach items="${personList}" var="person">
      <ul>
        <li>
      <b>${person.name}</b>
      <a href="/pessoas/mostrar/${person.id}">detalhes</a>
       - <a href="/pessoas/editar?id=${person.id}">editar</a>
       - <a href="/pessoas/deletar?id=${person.id}">excluir</a><br>
        </li>
      </ul>
    </c:forEach>
    <br><a href="/pessoas/index/">voltar</a>
  </body>
</html>