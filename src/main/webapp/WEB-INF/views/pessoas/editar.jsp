<html>
<head>
    <title>Alterar Cadastro</title>
</head>
<body>
Alterar
  <form action="/pessoas/alterar" method="post">
    <input type="hidden" name="id" value="${person.id}"/>
    Nome: <input type="text" name="name" value="${person.name}"/>
    Telefone: <input type="text" name="phone" value="${person.phone}"/>
    <input type="submit" value="Alterar"/>
  </form>

</body>
</html>
