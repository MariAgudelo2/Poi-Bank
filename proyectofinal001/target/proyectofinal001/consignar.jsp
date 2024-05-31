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
              <a class="nav-link active" aria-current="page" href="banco.jsp"
                >Home</a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="crearCuenta.jsp"
                >Abre una cuenta nueva</a
              >
            </li>
            <li class="nav-item">
              <form class="tuCuentaBtn" action="tuCuenta" method="Get">
                <button type="submit" class="nav-link" href="tuCuenta.jsp">
                  Tu cuenta
                </button>
              </form>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="sobreNosotros.jsp">Sobre nosotros</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <!-- Features section-->
    <section>
      <div class="centrar">
        <form action="consignar" method="post">
          <br /><br />
          <h3>
            ¿A qué cuenta deseas realizar la <br />
            consignación?
          </h3>

          <select name="tipoCuenta">
            <c:forEach items="${cuentas}" var="cuenta">
              <option name="tipoCuenta">
                <c:if test="${cuenta.tipoCuenta != 'corriente'}">
                  <c:out value="${cuenta.tipoCuenta}" />
                </c:if>
              </option>
            </c:forEach>
          </select>
          <h5>¿En qué moneda?</h5>
          <select name="moneda">
            <option>USD ($)</option>
            <option>EUR (€)</option>
            <option>COP ($)</option>
          </select>
          <label>Valor a consignar: </label>
          <input name="monto" type="number" min="1" />
          <br />
          <button type="submit">Consignar</button>
        </form>
      </div>
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
  <style>
    body {
      font-family: Arial, sans-serif;
      color: #322d2c;
      font-weight: 700;
    }
    body h3 {
      font-weight: 700;
    }
    body input {
      margin: 10px;
    }
    body select {
      height: 30px;
      margin: 10px;
    }
    #cuerpo {
      padding-top: 100px;
    }
    .centrar {
      display: flex;
      justify-content: center;
      align-items: center;
      font-family: Arial, sans-serif;
      padding-bottom: 100px;
      padding-top: 100px;
    }
    button {
      background-color: #aaaa7b;
      margin-bottom: 10px;
      border: 1px solid #aaaa7b;
      border-radius: 5px;
      box-sizing: border-box;
    }
    button:hover {
      background-color: #322d2c;
      color: #fff;
    }
  </style>
</html>
