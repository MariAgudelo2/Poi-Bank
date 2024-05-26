<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registrarse</title>
  </head>
  <body>
    <form action="registro" method="post">
      <h2>Registrarse</h2>
      <label>Nombre(s): </label>
      <input type="text" name="nombres" />
      <br />
      <label>Apellidos: </label>
      <input type="text" name="apellidos" />
      <br />
      <label>Email: </label>
      <input type="email" name="email" />
      <br />
      <label>Número de identificación: </label>
      <input type="number" name="identificacion" />
      <br />
      <label>País: </label>
      <select name="pais">
        <option>Argentina</option>
        <option>Colombia</option>
        <option>Ecuador</option>
        <option>México</option>
      </select>
      <button type="submit">Enviar</button>
    </form>
  </body>
</html>
