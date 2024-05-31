<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" type="image/x-icon" href="assets/icon.PNG" />
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
      <label>País: </label>
      <select name="pais">
        <option>Argentina</option>
        <option>Colombia</option>
        <option>Ecuador</option>
        <option>México</option>
      </select>
      <br />
      <label>Número de identificación: </label>
      <input type="number" name="id" />
      <br />
      <label>Contraseña: </label>
      <input type="password" name="contrasena" />
      <br />
      <button type="submit">Enviar</button>
    </form>
  </body>
  <style>
    body {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      font-family: Arial, sans-serif;
    }
    form {
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    }
    select,
    input,
    button {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      box-sizing: border-box;
    }
    select {
      height: 40px;
    }
    input[type="submit"] {
      background-color: #4caf50;
      color: #fff;
      cursor: pointer;
    }
    input[type="submit"]:hover {
      background-color: #3e8e41;
    }
    button:hover {
      background-color: #322d2c;
      color: #fff;
    }
  </style>
</html>
