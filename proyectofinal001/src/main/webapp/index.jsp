<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="icon" type="image/x-icon" href="assets/icon.PNG" />
    <title>Hoi-Poi</title>
  </head>
  <body>
    <div>
      <img src="assets/iconBlack.png" />
    </div>
    <div>
      <h1>Bienvenido(a) a Hoi-Poi</h1>
      <h2>Tu banco e inmobiliaria preferidos</h2>
      <a href="registro.jsp">
        <button>Registrarse</button>
      </a>
      <a href="sesion.jsp">
        <button>Iniciar sesión</button>
      </a>
    </div>
  </body>
  <style>
    body {
      text-align: center;
      display: flex;
      font-family: Arial, sans-serif;
      color: #322d2c;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    body img {
      height: 250px;
    }

    .buttons {
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    button {
      background-color: #fff;
      color: #322d2c;
      border: 2px solid #322d2c;
      border-radius: 5px;
      padding: 10px 20px;
      font-size: 16px;
      margin-bottom: 10px;
      cursor: pointer;
    }
    button:hover {
      background-color: #322d2c;
      color: #fff;
    }
  </style>
</html>
