<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Iniciar sesión</title>
  </head>
  <body>
    <form action="sesion" method="get">
      <h2>Iniciar sesión</h2>
      <label>País: </label>
      <select name="pais1">
        <option>Argentina</option>
        <option>Colombia</option>
        <option>Ecuador</option>
        <option>México</option>
      </select>
      <br />
      <label>Número de identificación: </label>
      <input type="number" name="id1" />
      <br />
      <label>Contraseña: </label>
      <input type="password" name="contrasena1" />
      <br />
      <button type="submit">Enviar</button>
    </form>
  </body>
</html>
