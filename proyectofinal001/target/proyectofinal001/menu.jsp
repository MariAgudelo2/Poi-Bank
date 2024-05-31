<%@ page contentType="text/html; charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="jakarta.tags.core" %>
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
      <h1>Bienvenido(a)</h1>
      <h3>
        <c:out value="${clienteNombres}" /><c:out value="${clienteApellidos}" />
      </h3>
      <br />
      <h2>¿Qué desea hacer?</h2>
      <a href="">
        <button>Ir a inmobiliaria</button>
      </a>
      <a href="banco.jsp">
        <button>Ir a Banco</button>
      </a>
    </div>
  </body>
  <style>
    body {
      text-align: center;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      font-family: Arial, sans-serif;
      color: #322d2c;
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
