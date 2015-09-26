<html>
<head>
    <title>Cadastro de Pessoas</title>
</head>
<body>
  <div><h1>Cadastrar Pessoa</h1></div>
  <form action="/pessoas/salvar" method="post">
    Nome: <input type="text" name="name"/><br>
    Data de Nascimento: <input type="date" name="dateBirth"/><br>
    Telefone: <input type="text" name="phone"/><br>
    Celular: <input type="text" name="mobile"/><br>
    <input type="submit" value="Cadastrar"/>
  </form>
  <br><a href="/pessoas/listar/">voltar</a>
</body>
</html>
