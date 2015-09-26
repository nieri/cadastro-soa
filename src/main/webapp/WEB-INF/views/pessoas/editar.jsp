<html>
<head>
    <title>Alterar Cadastro</title>
</head>
<body>
Alterar Cadastro
  <form action="/pessoas/alterar" method="post">
    <input type="hidden" name="id" value="${person.id}"/><br><br>
    Nome: <input type="text" name="name" value="${person.name}"/><br>
    Data de Nascimento: <input type="text" name="dateBirth" value="${person.dateBirthFormatted}"/><br>
    Telefone: <input type="text" name="phone" value="${person.phone}"/><br>
    Celular: <input type="text" name="mobile" value="${person.mobile}"/><br>
    <input type="submit" value="Alterar"/>
  </form>

  <br> <a href="/pessoas/listar/">listar</a>

</body>
</html>
