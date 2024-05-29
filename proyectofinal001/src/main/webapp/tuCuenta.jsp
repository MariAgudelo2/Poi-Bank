<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tu cuenta</title>
  </head>
  <body>
    <table border="1">
      <tr>
        <th>Nombres</th>
        <th>Apellidos</th>
        <th>identificación</th>
        <th>Email</th>
      </tr>
      <tbody>
        <c:set value="${cliente1}" var="cliente">
          <tr>
            <td><c:out value="${cliente.getNombres}" /></td>
            <td><c:out value="${cliente.getApellidos}" /></td>
            <td><c:out value="${cliente.getId}" /></td>
            <td><c:out value="${cliente.getEmail}" /></td>
          </tr>
        </c:set>
      </tbody>
    </table>
    <br />
    <table border="1">
      <tr>
        <th>Tipo de cuenta</th>
        <th>Nro de cuenta</th>
      </tr>
      <tbody>
        <c:forEach items="${cuentas}" var="cuenta">
          <tr>
            <td><c:out value="${cuenta.getTipoCuenta}" /></td>
            <td><c:out value="${cuenta.getNroCuenta}" /></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>
