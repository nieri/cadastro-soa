<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>Lista de Pessoas</title>
  </head>
  <body>

  Lista de Pessoas <br><br>

    <c:forEach items="${personList}" var="person">
      ${person.name} ${person.phone}
    </c:forEach>
  </body>
</html>