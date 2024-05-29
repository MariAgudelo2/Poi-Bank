<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Abre una cuenta</title>
  </head>
  <script>
    function redireccionar() {
      setTimeout(function () {
        window.location.href = "banco.jsp";
      }, 8000);
    }
    window.onload = redireccionar;
  </script>
  <body>
    <h2>Cuenta creada exitosamente</h2>
    Serás redireccionado a la página principal en unos segundos, para conocer
    los detalles de tu cuenta, dirígete a la pestaña "tu cuenta" en la parte
    superior
  </body>
</html>
