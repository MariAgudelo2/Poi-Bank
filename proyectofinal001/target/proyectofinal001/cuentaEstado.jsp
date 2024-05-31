<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cancelar cuenta</title>
  </head>
  <body>
    <script>
      function redireccionar() {
        setTimeout(function () {
          window.location.href = "banco.jsp";
        }, 7000);
      }
      window.onload = redireccionar;
    </script>
    <div>
      <div>
        <img src="assets/iconBlack.png" />
      </div>
      <h2>Cuenta cancelada con éxito</h2>
      <p>
        Serás redireccionado en unos segundos, para conocer los detalles de tu
        cuenta, dirígete a la pestaña "tu cuenta" en la parte superior
      </p>
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
      height: 120px;
    }
  </style>
</html>
