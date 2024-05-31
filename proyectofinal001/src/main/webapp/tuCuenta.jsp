<%@ page contentType="text/html; charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Poi-Bank</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/icon.PNG" />
    <!-- Bootstrap icons-->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
      rel="stylesheet"
    />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
  </head>

  <body>
    <!-- Responsive navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container px-5">
        <a class="navbar-brand" href="#!">Poi Bank</a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="banco.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="crearCuenta.jsp"
                >Abre una cuenta nueva</a
              >
            </li>
            <li class="nav-item">
              <form class="tuCuentaBtn" action="tuCuenta" method="Get">
                <button
                  type="submit"
                  class="nav-link active"
                  aria-current="page"
                  href="tuCuenta.jsp"
                >
                  Tu cuenta
                </button>
              </form>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#!">Sobre nosotros</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Features section-->
    <section>
      <div class="centrarTablas">
        <table class="styled-table">
          <tr>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Identificación</th>
            <th>Email</th>
          </tr>
          <tbody>
            <c:set value="${cliente1}" var="cliente" />
            <tr>
              <td>
                <c:out value="${cliente.nombres}" />
              </td>
              <td>
                <c:out value="${cliente.apellidos}" />
              </td>
              <td>
                <c:out value="${cliente.id}" />
              </td>
              <td>
                <c:out value="${cliente.email}" />
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div class="centrarTablas">
        <table class="styled-table">
          <tr>
            <th>Tipo de cuenta</th>
            <th>Nro de cuenta</th>
          </tr>
          <tbody>
            <c:forEach items="${cuentas}" var="cuenta">
              <tr>
                <td>
                  <c:out value="${cuenta.tipoCuenta}" />
                </td>
                <td>
                  <c:out value="${cuenta.nroCuenta}" />
                </td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
      <br /><br />
      <div class="centrar">
        <p>
          Conoce nuestros
          <a class="text-decoration-none" href="#!">términos y condiciones</a>
        </p>
      </div>
      <br />
      <br />
    </section>

    <!-- Footer-->
    <footer class="py-5 bg-dark">
      <div class="container px-5">
        <p class="m-0 text-center text-white">Copyright &copy; Poi-Bank 2024</p>
      </div>
    </footer>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <!-- * *                               SB Forms JS                               * *-->
    <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
    <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
    <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
  </body>
</html>
