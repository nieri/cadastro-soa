<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>Lista de Pessoas</title>
  </head>
  <body>
    <c:forEach items="${personList}" var="person">
      ${person.name} ${person.phone}
      <a href="/pessoas/mostrar/${person.id}">detalhes</a>
       - <a href="/pessoas/editar?id=${person.id}">editar</a>
       - <a href="/pessoas/deletar?id=${person.id}">excluir</a><br>
    </c:forEach>
    <br><a href="/pessoas/index/">voltar</a>
  </body>
</html>