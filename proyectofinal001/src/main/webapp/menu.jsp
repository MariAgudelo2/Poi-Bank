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
    Bienvenido(a)
    <c:out value="${clienteNombres}" />
    <c:out value="${clienteApellidos}" />
    <br />
    ¿Qué desea hacer?
    <a href="subasta.jsp">
      <button>Ir a inmobiliaria</button>
    </a>
    <a href="banco.jsp">
      <button>Ir a Banco</button>
    </a>
  </body>
</html>
